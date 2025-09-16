package ninja.lemes.auth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;

import java.util.UUID;

@Entity
public class Account {

    @Id
    @Column(updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();;

    @Column(updatable = false, nullable = false)
    private Long createdAt = System.currentTimeMillis() / 1000;

    @Column(updatable = false, nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String name;

    private String role;

    @Column(nullable = false)
    private String hash;

    @Column(nullable = false)
    private String salt;

    public UUID getId() {
        return this.id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(final Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(final String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(final String salt) {
        this.salt = salt;
    }

}
