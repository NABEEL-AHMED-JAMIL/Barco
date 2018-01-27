package com.ballistic.barco.domain.activity;

import com.ballistic.barco.domain.constant.Gender;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Nabeel on 1/27/2018.
 */
// final class
@Embeddable
public class UserInfo {

    @Size(min = 0, max = 50)
    @Column(name = "first_name")
    private String firstname;
    @Size(min = 0, max = 50)
    @Column(name = "lastname")
    private String lastname;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    public UserInfo() {}
    public UserInfo(String firstname, String lastname, Address address, Gender gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.gender = gender;
    }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    @Override
    public String toString() {
        return "UserInfo{" + "firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' +
                ", address=" + address + ", gender=" + gender + '}';
    }
}
