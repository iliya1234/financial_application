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

    @Column(name = "password",nullable = false)
    private String password;


    @JsonIgnore
    @OneToMany(mappedBy="authorizationClientCategory",cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories;

    @JsonIgnore
    @OneToMany(mappedBy="users",cascade = CascadeType.ALL)
    private List<Target> targets;

    @JsonIgnore
    @OneToMany(mappedBy="clients",cascade = CascadeType.ALL)
    private List<IncomeCategory> incomeCategories;

    @JsonIgnore
    @OneToOne(mappedBy = "authorization",cascade = CascadeType.ALL)
    private Client client;



    public AuthorizationClient() {
    }

    public AuthorizationClient(Integer id, String username, String password, List<ProductCategory> productCategories, List<Target> targets, List<IncomeCategory> incomeCategories, Client client) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.productCategories = productCategories;
        this.targets = targets;
        this.incomeCategories = incomeCategories;
        this.client = client;
    }

    @Override
    public String toString() {
        return "AuthorizationClient{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", productCategories=" + productCategories +
                ", targets=" + targets +
                ", incomeCategories=" + incomeCategories +
                ", client=" + client +
                '}';
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

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public List<IncomeCategory> getIncomeCategories() {
        return incomeCategories;
    }

    public void setIncomeCategories(List<IncomeCategory> incomeCategories) {
        this.incomeCategories = incomeCategories;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
