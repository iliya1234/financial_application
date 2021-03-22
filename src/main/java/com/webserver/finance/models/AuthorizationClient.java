package com.webserver.finance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "authorizationclients")
public class AuthorizationClient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy="authorizationClient", cascade = CascadeType.ALL)
    private List<Purchase> purchases;

    @JsonIgnore
    @OneToMany(mappedBy="authorizationClientCategory", cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories;

    @JsonIgnore
    @OneToMany(mappedBy="userId", cascade = CascadeType.ALL)
    private List<Product> products;



    public AuthorizationClient() {
    }

    public AuthorizationClient(Integer id, String username, String password, List<Purchase> purchases, List<ProductCategory> productCategories, List<Product> products) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.purchases = purchases;
        this.productCategories = productCategories;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "AuthorizationClient{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", purchases=" + purchases +
                ", productCategories=" + productCategories +
                ", products=" + products +
                '}';
    }
}
