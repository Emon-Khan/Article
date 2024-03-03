package com.emonkhan.entity;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    public Employer(){}

    public Employer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
