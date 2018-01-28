package com.ballistic.barco.domain.users;

import com.ballistic.barco.domain.activity.UserInfo;
import com.ballistic.barco.domain.auth.User;
import com.ballistic.barco.domain.model.Product;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nabeel on 1/25/2018.
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
@DiscriminatorValue( value = "SUPPLIER" )
public class Supplier extends User {

    @Embedded
    private UserInfo userInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<Product> products;
    @Column(name = "phone")
    private String phone;

    public Supplier() {}
    public Supplier(UserInfo userInfo, List<Product> products) {
        this.userInfo = userInfo;
        this.products = products;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Supplier{" + "userInfo=" + userInfo + ", products=" + products + '}';
    }
}
