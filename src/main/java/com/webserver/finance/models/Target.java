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

    @Column(name = "sumend",nullable = false)
    private Double sumend;

    @Column(name = "sumuser",nullable = false)
    private Double sumuser;

    @ManyToOne
    @JoinColumn(name = "users",nullable = false)
    private AuthorizationClient users;

    public Target() {
    }

    public Target(Integer id, String name, Date start, Date end, Double sumend, Double sumuser, AuthorizationClient users) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.sumend = sumend;
        this.sumuser = sumuser;
        this.users = users;
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

    public Double getSumend() {
        return sumend;
    }

    public void setSumend(Double sumend) {
        this.sumend = sumend;
    }

    public Double getSumuser() {
        return sumuser;
    }

    public void setSumuser(Double sumuser) {
        this.sumuser = sumuser;
    }

    public AuthorizationClient getUsers() {
        return users;
    }

    public void setUsers(AuthorizationClient users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", sumend=" + sumend +
                ", sumuser=" + sumuser +
                ", users=" + users +
                '}';
    }
}
