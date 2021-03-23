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
    @OneToMany(mappedBy="authorizationClientCategory", cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories;




    public AuthorizationClient() {
    }

    public AuthorizationClient(Integer id, String username, String password, List<ProductCategory> productCategories) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    @Override
    public String toString() {
        return "AuthorizationClient{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", productCategories=" + productCategories +
                '}';
    }
}
