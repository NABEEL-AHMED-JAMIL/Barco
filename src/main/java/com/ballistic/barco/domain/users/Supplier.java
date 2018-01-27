package com.ballistic.barco.domain.users;

import com.ballistic.barco.domain.activity.UserInfo;
import com.ballistic.barco.domain.auth.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by Nabeel on 1/25/2018.
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
@DiscriminatorValue( value = "SUPPLIER" )
public class Supplier extends User {

    @Embedded
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
