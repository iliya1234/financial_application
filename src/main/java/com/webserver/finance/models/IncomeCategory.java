package com.webserver.finance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "incomecategories")
public class IncomeCategory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "clients",nullable = false)
    private AuthorizationClient clients;

    @JsonIgnore
    @OneToMany(mappedBy="incomeCategory",cascade = CascadeType.ALL)
    private List<IncomeProduct> incomeProducts;

    public IncomeCategory() {
    }

    public IncomeCategory(Integer id, String name, AuthorizationClient clients, List<IncomeProduct> incomeProducts) {
        this.id = id;
        this.name = name;
        this.clients = clients;
        this.incomeProducts = incomeProducts;
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

    public AuthorizationClient getClients() {
        return clients;
    }

    public void setClients(AuthorizationClient clients) {
        this.clients = clients;
    }

    public List<IncomeProduct> getIncomeProducts() {
        return incomeProducts;
    }

    public void setIncomeProducts(List<IncomeProduct> incomeProducts) {
        this.incomeProducts = incomeProducts;
    }

    @Override
    public String toString() {
        return "IncomeCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clients=" + clients +
                ", incomeProducts=" + incomeProducts +
                '}';
    }
}
