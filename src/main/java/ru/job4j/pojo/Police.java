package ru.job4j.pojo;

import java.util.Date;

public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setOwner("Petr Arsentev");
        license.setModel("Toyota");
        license.setCode("xxx1x");
        license.setCreated(new Date());

        System.out.println(license.getOwner()
                + " has a car - " + license.getModel() + " : " + license.getCode());

    }
}
