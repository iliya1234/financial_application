package com.webserver.finance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productcategories")
public class ProductCategory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="productCategory")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "authorizationclients_id")
    private AuthorizationClient authorizationClientCategory;

    public ProductCategory() {
    }

    public ProductCategory(int id, String name, List<Product> products, AuthorizationClient authorizationClientCategory) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.authorizationClientCategory = authorizationClientCategory;
    }

    public AuthorizationClient getAuthorizationClientCategory() {
        return authorizationClientCategory;
    }

    public void setAuthorizationClientCategory(AuthorizationClient authorizationClientCategory) {
        this.authorizationClientCategory = authorizationClientCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
