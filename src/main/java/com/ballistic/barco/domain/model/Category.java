package com.ballistic.barco.domain.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nabeel on 1/25/2018.
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;

    public Category() {}
    public Category(String categoryName, String description, List<Product> products) {
        this.categoryName = categoryName;
        this.description = description;
        this.products = products;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    @Override
    public String toString() {
        return "Category {" + "id=" + id + ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' + ", products=" + products + '}';
    }
}
