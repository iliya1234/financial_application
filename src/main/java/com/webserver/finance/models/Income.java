package com.webserver.finance.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "incomes")
public class Income {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "id_client")
    private Integer id_client;

    @Column(name = "date")
    private Date date;

    @Column(name = "id_incomecategory")
    private Integer id_incomecategory;

    @Column(name = "total")
    private Double total;

    @Column(name = "discription")
    private String discription;

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

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public Integer getId_incomecategory() {
        return id_incomecategory;
    }

    public void setId_incomecategory(Integer id_incomecategory) {
        this.id_incomecategory = id_incomecategory;
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
}