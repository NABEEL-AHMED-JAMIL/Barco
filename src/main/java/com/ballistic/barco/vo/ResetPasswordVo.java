package com.ballistic.barco.vo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Nabeel on 1/22/2018.
 */
public class ResetPasswordVo {

    @NotNull(message = "id can not be null.")
    @NotEmpty(message = "id not be empty")
    private Long id;
    @NotNull(message = "password can not be null.")
    @NotEmpty(message = "password not be empty")
    private String password;
    @NotNull(message = "resetPasswordKey can not be null.")
    @NotEmpty(message = "resetPasswordKey not be empty")
    private String resetPasswordKey;

    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }
    public void setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
    }

}
