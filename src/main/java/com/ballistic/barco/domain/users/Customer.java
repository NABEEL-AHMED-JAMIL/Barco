package com.ballistic.barco.domain.users;

import com.ballistic.barco.domain.activity.UserInfo;
import com.ballistic.barco.domain.auth.User;
import com.ballistic.barco.domain.model.CustomerOrder;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nabeel on 1/25/2018.
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
@DiscriminatorValue( value = "CUSTOMER" )
public class Customer extends User {

    @Embedded
    private UserInfo userInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CustomerOrder> customerOrders;

    public Customer() {}
    public Customer(UserInfo userInfo, List<CustomerOrder> customerOrders) {
        this.userInfo = userInfo;
        this.customerOrders = customerOrders;
    }

    public UserInfo getUserInfo() { return userInfo; }
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<CustomerOrder> getCustomerOrders() { return customerOrders; }
    public void setCustomerOrders(List<CustomerOrder> customerOrders) { this.customerOrders = customerOrders; }

    @Override
    public String toString() {
        return "Customer{" + "userInfo=" + userInfo + ", customerOrders=" + customerOrders + '}';
    }
}
