package com.ballistic.barco.domain;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;
/**
 * Created by Nabeel on 1/11/2018.
 */
@Entity
public class User implements IUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 0, max = 50)
    private String firstname;

    @Size(min = 0, max = 50)
    private String lastname;

    @Size(min = 0, max = 50)
    @Column(unique = true, nullable = false)
    private String username;

    @Size(min = 0, max = 500)
    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 0, max = 500)
    private String password;

    @Column(name = "activated")
    private Boolean activated;
    // this help us to active and dis-active the account
    @Size(min = 0, max = 100)
    @Column(name = "activation_key")
    private String activationKey;
    // help to reset password
    @Size(min = 0, max = 500)
    @Column(name = "rest_password_key")
    private String resetPasswordKey;
    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority"))
    private Set<Authority> authoritys;

    @Override
    public Long getId() { return id; }
    @Override
    public void setId(Long id) { this.id = id; }

    @Override
    public String getFirstname() {
        return firstname;
    }
    @Override
    public void setFirstname(String firstname) { this.firstname = firstname; }

    @Override
    public String getLastname() {
        return lastname;
    }
    @Override
    public void setLastname(String lastname) { this.lastname = lastname; }

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public void setUsername(String username) { this.username = username; }

    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) { this.email = email; }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) { this.password = password; }

    @Override
    public Boolean isActivated() {
        return activated;
    }
    @Override
    public Boolean getActivated() {
        return activated;
    }
    @Override
    public void setActivated(Boolean activated) { this.activated = activated; }

    @Override
    public String getActivationKey() {
        return activationKey;
    }
    @Override
    public void setActivationKey(String activationKey) { this.activationKey = activationKey; }

    @Override
    public String getResetPasswordKey() {
        return resetPasswordKey;
    }
    @Override
    public void setResetPasswordKey(String resetPasswordKey) { this.resetPasswordKey = resetPasswordKey; }

    @Override
    public Set<Authority> getAuthoritys() { return authoritys; }
    @Override
    public void setAuthoritys(Set<Authority> authoritys) { this.authoritys = authoritys; }
}
