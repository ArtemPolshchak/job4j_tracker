package ru.job4j.map;

import java.util.Objects;

/**
 * @author Artem Polshchak on 29.10.2021.
 * @project job4j-tracker
 */
public class Student {
    private String name;
    private String account;
    private String group;

    public Student(String name, String account, String group) {
        this.name = name;
        this.account = account;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(getName(),
                student.getName()) && Objects.equals(getAccount(),
                student.getAccount()) && Objects.equals(getGroup(),
                student.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAccount(), getGroup());
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", account='" + account + '\''
                + ", group='" + group + '\'' + '}';
    }
}
