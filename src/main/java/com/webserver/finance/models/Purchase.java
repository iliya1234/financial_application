package com.webserver.finance.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_client")
    private AuthorizationClient authorizationClient;

    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;

    @Column(name = "date")
    private Date date;

    @Column(name = "total")
    private Double total;

    @Column(name = "discription")
    private String discription;


    public Purchase() {
    }

    public Purchase(Integer id, AuthorizationClient authorizationClient, Product product, Date date, Double total, String discription) {
        this.id = id;
        this.authorizationClient = authorizationClient;
        this.product = product;
        this.date = date;
        this.total = total;
        this.discription = discription;
    }

    public AuthorizationClient getAuthorizationClient() {
        return authorizationClient;
    }

    public void setAuthorizationClient(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
