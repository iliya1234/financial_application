package com.webserver.finance.models;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;


@Entity
@Table(name = "incomecategorizations")
public class IncomeCategorization {
    @Id
    @Column(name = "id_incomeproduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_incomeproduct;

    @Column(name = "id_incomecategory")
    private Integer id_incomecategory;

    public Integer getId_incomeproduct() {
        return id_incomeproduct;
    }

    public void setId_incomeproduct(Integer id_incomeproduct) {
        this.id_incomeproduct = id_incomeproduct;
    }

    public Integer getId_incomecategory() {
        return id_incomecategory;
    }

    public void setId_incomecategory(Integer id_incomecategory) {
        this.id_incomecategory = id_incomecategory;
    }
}
