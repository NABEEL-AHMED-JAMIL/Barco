package com.ballistic.barco.domain.model;

import com.ballistic.barco.domain.users.Customer;
import com.ballistic.barco.domain.users.Employee;
import com.ballistic.barco.domain.users.Shipper;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Nabeel on 1/25/2018.
 */
@Entity
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerOrder", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;


    public CustomerOrder() {}
    public CustomerOrder(Date orderDate, Customer customer, Employee employee,
                         Shipper shipper, List<OrderDetail> orderDetails) {
        this.orderDate = orderDate;
        this.customer = customer;
        this.employee = employee;
        this.shipper = shipper;
        this.orderDetails = orderDetails;
    }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Shipper getShipper() {
        return shipper;
    }
    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "CustomerOrder {" + "orderId=" + orderId + ", orderDate=" + orderDate +
                ", customer=" + customer + ", employee=" + employee +
                ", shipper=" + shipper + ", orderDetails=" + orderDetails + '}';
    }
}
