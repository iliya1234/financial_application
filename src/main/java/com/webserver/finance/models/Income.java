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

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "incomeproduct_id",nullable = false)
    private IncomeProduct incomeProduct;

    public Income() {
    }

    public Income(Integer id, Date date, Double total, String description, IncomeProduct incomeProduct) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.description = description;
        this.incomeProduct = incomeProduct;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                ", description='" + description + '\'' +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IncomeProduct getIncomeProduct() {
        return incomeProduct;
    }

    public void setIncomeProduct(IncomeProduct incomeProduct) {
        this.incomeProduct = incomeProduct;
    }
}