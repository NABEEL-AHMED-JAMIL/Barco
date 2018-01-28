package com.ballistic.barco.domain.users;

import com.ballistic.barco.domain.activity.Attendance;
import com.ballistic.barco.domain.activity.Salary;
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
@DiscriminatorValue( value = "EMPLOYEE" )
public class Employee extends User {

    // Photo
    @Embedded
    private UserInfo userInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Salary> salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Attendance> attendance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<CustomerOrder> customerOrders;
    @Column(name = "note")
    private String note;

    public Employee() {}

    public Employee(UserInfo userInfo, List<Salary> salary, List<Attendance> attendance,
                    List<CustomerOrder> customerOrders, String note) {
        this.userInfo = userInfo;
        this.salary = salary;
        this.attendance = attendance;
        this.customerOrders = customerOrders;
        this.note = note;
    }

    public UserInfo getUserInfo() { return userInfo; }
    public void setUserInfo(UserInfo userInfo) { this.userInfo = userInfo; }

    public List<Salary> getSalary() { return salary; }
    public void setSalary(List<Salary> salary) { this.salary = salary; }

    public List<Attendance> getAttendance() { return attendance; }
    public void setAttendance(List<Attendance> attendance) { this.attendance = attendance; }

    public List<CustomerOrder> getCustomerOrders() { return customerOrders; }
    public void setCustomerOrders(List<CustomerOrder> customerOrders) { this.customerOrders = customerOrders; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    @Override
    public String toString() {
        return "Employee{" + "userInfo=" + userInfo + ", salary=" + salary + ", attendance=" + attendance + '}';
    }
}
