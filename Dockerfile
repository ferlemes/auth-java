FROM gradle:jdk21-corretto AS build

WORKDIR /auth-java
COPY build.gradle settings.gradle /auth-java/
COPY gradle /auth-java/gradle
RUN gradle dependencies -x test --no-daemon || return 0

COPY . /auth-java
RUN gradle clean build --no-daemon

FROM amazoncorretto:21-alpine

WORKDIR /auth-java

COPY --from=build /auth-java/build/libs/*.jar auth-java.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "auth-java.jar"]
