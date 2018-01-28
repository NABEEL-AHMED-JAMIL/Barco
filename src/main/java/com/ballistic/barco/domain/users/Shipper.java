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
@DiscriminatorValue( value = "SHIPPER" )
public class Shipper extends User {

    @Embedded
    private UserInfo userInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipper", fetch = FetchType.LAZY)
    private List<CustomerOrder> customerOrders;
    private String phone;
    private String companyName;

    public Shipper() {}
    public Shipper(UserInfo userInfo, List<CustomerOrder> customerOrders) {
        this.userInfo = userInfo;
        this.customerOrders = customerOrders;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<CustomerOrder> getCustomerOrders() { return customerOrders; }
    public void setCustomerOrders(List<CustomerOrder> customerOrders) { this.customerOrders = customerOrders; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    @Override
    public String toString() {
        return "Shipper{" + "userInfo=" + userInfo + ", customerOrders=" + customerOrders + '}';
    }
}
