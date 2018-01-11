package com.ballistic.barco.domain;

import java.util.Set;
import java.util.UUID;

/**
 * Created by Nabeel on 1/11/2018.
 */
public interface IUser {

    public UUID getUuid();
    public void setUuid(UUID uuid);

    public String getFirstname();
    public void setFirstname(String firstname);

    public String getLastname();
    public void setLastname(String lastname);

    public String getUsername();
    public void setUsername(String username);

    public String getEmail();
    public void setEmail(String email);

    public String getPassword();
    public void setPassword(String password);

    public Boolean isActivated();
    public Boolean getActivated();
    public void setActivated(Boolean activated);

    public String getActivationKey();
    public void setActivationKey(String activationKey);

    public String getResetPasswordKey();
    public void setResetPasswordKey(String resetPasswordKey);

    public Set<Authority> getAuthoritys();
    public void setAuthoritys(Set<Authority> authoritys);
}
