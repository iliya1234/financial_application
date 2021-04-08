package com.webserver.finance.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "date",nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    private Date date;

    @Column(name = "total",nullable = false)
    private Double total;

    @Column(name = "discription")
    private String discription;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;


    public Purchase() {
    }

    public Purchase(Integer id, Date date, Double total, String discription, Product product) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.discription = discription;
        this.product = product;
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

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                ", discription='" + discription + '\'' +
                ", product=" + product +
                '}';
    }
}

