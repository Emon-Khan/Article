package com.emonkhan.entity;

import java.util.Objects;

public class Employer {
    private String name;
    private int employerId;

    public Employer(String name, int employerId) {
        this.name = name;
        this.employerId = employerId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer employer)) return false;
        return getEmployerId() == employer.getEmployerId() && Objects.equals(getName(), employer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmployerId());
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", employerId=" + employerId +
                '}';
    }
}
