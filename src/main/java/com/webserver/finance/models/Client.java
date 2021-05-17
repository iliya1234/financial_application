package com.webserver.finance.models;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phone",nullable = false)
    private String phone;


    @OneToOne
    @JoinColumn(name="clients_id")
    private AuthorizationClient authorization;


    public Client() {
    }

    public Client(Integer id, String name, String email, String phone, AuthorizationClient authorization) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.authorization = authorization;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", authorization=" + authorization +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AuthorizationClient getAuthorization() {
        return authorization;
    }

    public void setAuthorization(AuthorizationClient authorization) {
        this.authorization = authorization;
    }
}