package com.webserver.finance.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "incomes")
public class Income {

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
    @JoinColumn(name = "incomeproduct_id",nullable = false)
    private IncomeProduct incomeProduct;

    public Income() {
    }

    public Income(Integer id, Date date, Double total, String discription, IncomeProduct incomeProduct) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.discription = discription;
        this.incomeProduct = incomeProduct;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                ", discription='" + discription + '\'' +
                ", incomeProduct=" + incomeProduct +
                '}';
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

    public IncomeProduct getIncomeProduct() {
        return incomeProduct;
    }

    public void setIncomeProduct(IncomeProduct incomeProduct) {
        this.incomeProduct = incomeProduct;
    }
}