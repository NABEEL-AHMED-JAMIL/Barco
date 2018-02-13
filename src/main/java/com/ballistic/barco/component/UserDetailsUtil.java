package com.ballistic.barco.component;

import com.ballistic.barco.domain.auth.Authority;
import com.ballistic.barco.domain.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;


/**
 * Created by Nabeel on 2/17/2018.
 */
@Component
public class UserDetailsUtil implements UserDetails {

    private String username;
    private String password;
    private Set<Authority> authoritys;
    private Boolean activated;
    private String type;
    private String device;

    @Autowired
    private DeviceUtil deviceUtil;


    public UserDetailsUtil() { }

    public UserDetailsUtil(User userFromDatabase) {
        this.username = userFromDatabase.getUsername();
        this.password = userFromDatabase.getPassword();
        this.authoritys = userFromDatabase.getAuthoritys();
        this.activated = userFromDatabase.getActivated();
        this.type = userFromDatabase.getType();
       // this.device = deviceUtil.generateAudience();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection) authoritys;
    }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getUsername() { return username; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return activated; }

    public String getType() { return type; }
    public String getDevice() { return device; }

    @Override
    public String toString() {
        return "UserDetailsUtil{" + "username='" + username + '\'' +
                ", password='" + password + '\'' + ", authoritys=" + authoritys +
                ", activated=" + activated + ", type='" + type + '\'' + ", device='" + device + '\'' + '}';
    }
}
