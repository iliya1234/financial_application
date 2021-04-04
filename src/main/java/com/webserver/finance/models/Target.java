package com.webserver.finance.models;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "targets")
public class Target {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "startdate",nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    private Date start;

    @Column(name = "enddate",nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    private Date end;

    @Column(name = "sum",nullable = false)
    private Double sum;

    @ManyToOne
    @JoinColumn(name = "users",nullable = false)
    private AuthorizationClient users;

    public Target() {
    }

    public Target(Integer id, String name, Date start, Date end, Double sum, AuthorizationClient users) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", sum=" + sum +
                ", users=" + users +
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public AuthorizationClient getUsers() {
        return users;
    }

    public void setUsers(AuthorizationClient users) {
        this.users = users;
    }
}
