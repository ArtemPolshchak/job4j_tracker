package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return Math.abs(a - x);
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperations(int a) {
        return multiply(a) + minus(a) + divide(a) + sum(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(sum(10));
        System.out.println(calculator.multiply(10));
        System.out.println(minus(10));
        System.out.println(calculator.divide(10));
        System.out.println();
        System.out.println(calculator.sumAllOperations(10));
    }
}