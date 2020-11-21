package ru.job4j.oop;

public class Main {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] transport = new Vehicle[]{plane, bus, train};
        for (Vehicle v : transport) {
            v.move();
            }
        }
    }

