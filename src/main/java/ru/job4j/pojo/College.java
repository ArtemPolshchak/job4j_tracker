package ru.job4j.pojo;

import java.util.Calendar;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("Artem");
        student.setLastName("Polshchak");
        student.setGroup("programming - Job4j.ru");
        student.setDateOfBeginStudy(new Date(19, Calendar.OCTOBER, 2020));

        System.out.println(
                student.getName() + " "
                        + student.getLastName()
                        + " поступил на курс по программированию "
                        + student.getGroup() + " " + student.getDateOfBeginStudy());
    }
}
