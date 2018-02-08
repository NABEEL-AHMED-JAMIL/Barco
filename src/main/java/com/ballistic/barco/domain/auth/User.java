package com.ballistic.barco.domain.auth;


import com.ballistic.barco.domain.DeletableModel;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;
/**
 * Created by Nabeel on 1/11/2018.
 */
@Entity
@Table(name = "user")
@Inheritance( strategy = InheritanceType.JOINED )
@DiscriminatorColumn( name="type", discriminatorType = DiscriminatorType.STRING, length = 255)
public class User extends DeletableModel implements IUser, Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
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
    @JoinTable(name = "user_role",    joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "authority"))
    private Set<Authority> authoritys;
    @Column(name = "type", insertable = false, updatable = false)
    private String type;
    
    
    @Override
    public Long getId() { return id; }
    @Override
    public void setId(Long id) { this.id = id; }

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
    
    
    public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	
	
	@Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", email='" + email +
                '\'' + ", password='" + password + '\'' + ", activated=" + activated +
                ", activationKey='" + activationKey + '\'' + ", resetPasswordKey='" +
                resetPasswordKey + '\'' + ", authoritys=" + authoritys + '}';
    }
}
