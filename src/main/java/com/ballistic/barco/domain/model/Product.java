package com.ballistic.barco.domain.model;

import com.ballistic.barco.domain.users.Supplier;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nabeel on 1/25/2018.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "unit")
    private String unit;
    @Column(name = "price", precision=10, scale=2, nullable = false)
    private Double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;

    public Product() {}
    public Product(String productName, Supplier supplier, Category category,
                   String unit, Double price, List<OrderDetail> orderDetails) {
        this.productName = productName;
        this.supplier = supplier;
        this.category = category;
        this.unit = unit;
        this.price = price;
        this.orderDetails = orderDetails;
    }

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Product {" + "productId=" + productId + ", productName='" + productName + '\'' +
                ", supplier=" + supplier + ", category=" + category +
                ", unit='" + unit + '\'' + ", price=" + price +
                ", orderDetails=" + orderDetails + '}';
    }
}
