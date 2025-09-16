docker run -it --rm -v $(pwd):/auth-java -w /auth-java -p 8080:8080 -u 1000:1000 gradle:jdk21-corretto bash
