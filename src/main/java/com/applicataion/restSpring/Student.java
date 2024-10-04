package com.applicataion.restSpring;

import java.util.Date;

public class Student {

    private Integer id;
    private String name;
    private String dob;

    public Student(String name) {
        this.name = name;
    }

    public Student(Integer id, String name, String dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString()
    {
        return String.format("Student [id=%s, name=%s, dob=%s]", id, name, dob);
    }
}
