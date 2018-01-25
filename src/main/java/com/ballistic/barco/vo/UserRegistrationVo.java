package com.ballistic.barco.vo;

import com.ballistic.barco.domain.auth.Authority;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Nabeel on 1/22/2018.
 */
public class UserRegistrationVo {

    @NotNull(message = "firstname can not be null.")
    @NotEmpty(message = "firstname not be empty")
    private String firstname;
    @NotNull(message = "lastname can not be null.")
    @NotEmpty(message = "lastname not be empty")
    private String lastname;
    @NotNull(message = "username can not be null.")
    @NotEmpty(message = "username not be empty")
    private String username;
    @NotNull(message = "email can not be null.")
    @NotEmpty(message = "email not be empty")
    @Email(message = "Please provide a valid email address", regexp="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String email;
    @NotNull(message = "password can not be null.")
    @NotEmpty(message = "password not be empty")
    private String password;
    private Boolean activated;
    @NotNull(message = "authoritys can not be null.")
    @NotEmpty(message = "authoritys not be empty")
    private Set<Authority> authoritys;

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Boolean getActivated() { return activated; }
    public void setActivated(Boolean activated) { this.activated = activated; }

    public Set<Authority> getAuthoritys() { return authoritys; }
    public void setAuthoritys(Set<Authority> authoritys) { this.authoritys = authoritys; }

}
