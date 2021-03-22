package com.webserver.finance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    private List<Purchase> purchases;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorizationclients_id")
    private AuthorizationClient userId;

    public Product() {
    }

    public Product(Integer id, String name, List<Purchase> purchases, ProductCategory productCategory, AuthorizationClient userId) {
        this.id = id;
        this.name = name;
        this.purchases = purchases;
        this.productCategory = productCategory;
        this.userId = userId;
    }

    public AuthorizationClient getUserId() {
        return userId;
    }

    public void setUserId(AuthorizationClient userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchases=" + purchases +
                ", productCategory=" + productCategory +
                ", userId=" + userId +
                '}';
    }
}
