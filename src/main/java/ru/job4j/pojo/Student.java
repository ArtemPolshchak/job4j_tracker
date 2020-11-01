package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String name;
    private String lastName;
    private String group;
    private Date dateOfBeginStudy;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public Student setGroup(String group) {
        this.group = group;
        return this;
    }

    public Date getDateOfBeginStudy() {
        return dateOfBeginStudy;
    }

    public Student setDateOfBeginStudy(Date dateOfBeginStudy) {
        this.dateOfBeginStudy = dateOfBeginStudy;
        return this;
    }
}
