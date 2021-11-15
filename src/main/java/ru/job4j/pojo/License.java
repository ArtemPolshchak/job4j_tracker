package ru.job4j.pojo;

import java.util.Date;
import java.util.Objects;

public class License {
    private String model;
    private String code;
    private Date created;
    private String owner;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        License license = (License) o;
        return Objects.equals(owner, license.owner)
                && Objects.equals(model, license.model)
                && Objects.equals(code, license.code)
                && Objects.equals(created, license.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, model, code, created);
    }
}
