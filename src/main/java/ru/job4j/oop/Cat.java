package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        System.out.println("Theres are gav`s name and gav`s food");
        gav.giveNick("gav");
        gav.eat("kotleta");
        gav.show();

        Cat black = new Cat();
        System.out.println("There are black`s name and black`s food");
        black.giveNick("black");
        black.eat("fish");
        black.show();
    }
}
