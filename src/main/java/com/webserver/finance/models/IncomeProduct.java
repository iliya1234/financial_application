package com.webserver.finance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "incomeproducts")
public class IncomeProduct {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private IncomeCategory incomeCategory;

    @JsonIgnore
    @OneToMany(mappedBy="incomeProduct", cascade = CascadeType.ALL)
    private List<Income> incomes;

    @Override
    public String toString() {
        return "IncomeProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", incomeCategory=" + incomeCategory +
                ", incomes=" + incomes +
                '}';
    }

    public IncomeProduct() {
    }

    public IncomeProduct(Integer id, String name, IncomeCategory incomeCategory, List<Income> incomes) {
        this.id = id;
        this.name = name;
        this.incomeCategory = incomeCategory;
        this.incomes = incomes;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    public IncomeCategory getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(IncomeCategory incomeCategory) {
        this.incomeCategory = incomeCategory;
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
}
