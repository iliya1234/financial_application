package com.webserver.finance.models;

import javax.persistence.*;

@Entity
@Table(name = "productcategorizatoins")
public class ProductCategorization {
    @Id
    @Column(name = "id_product")
    private Integer id_product;


    @Column(name = "id_category")
    private Integer id_category;

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }
}
