package com.webserver.finance.models;

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

    @OneToMany(mappedBy = "authorizationClient")
    private List<Purchase> purchases;

    public AuthorizationClient() {
    }

    public AuthorizationClient(Integer id, String username, String password, List<Purchase> purchases) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.purchases = purchases;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
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
}
