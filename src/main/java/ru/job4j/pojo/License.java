package ru.job4j.pojo;

import java.util.Date;

public class License {
    public String getOwner() {
        return owner;
    }

    public License setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getModel() {
        return model;
    }

    public License setModel(String model) {
        this.model = model;
        return this;
    }

    public String getCode() {
        return code;
    }

    public License setCode(String code) {
        this.code = code;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public License setCreated(Date created) {
        this.created = created;
        return this;
    }

    private String owner;
    private String model;
    private String code;
    private Date created;
}
