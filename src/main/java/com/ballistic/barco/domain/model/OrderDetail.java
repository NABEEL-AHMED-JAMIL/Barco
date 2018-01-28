package com.ballistic.barco.domain.model;

import javax.persistence.*;

/**
 * Created by Nabeel on 1/25/2018.
 */
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_detail_id")
    private Long orderDetailId;
    @Column(name = "quantity")
    private Long quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder customerOrder;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderDetail() {}
    public OrderDetail(Long quantity, CustomerOrder customerOrder, Product product) {
        this.quantity = quantity;
        this.customerOrder = customerOrder;
        this.product = product;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }
    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }
    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetail {" + "orderDetailId=" + orderDetailId + ", quantity=" + quantity +
                ", customerOrder=" + customerOrder + ", product=" + product + '}';
    }
}