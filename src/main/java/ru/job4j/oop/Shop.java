package ru.job4j.oop;

public class Shop {

    private static Object liquidationProduct;

    public static void main(String[] args) {
        Product product = (Product) of("Oil", 100);
        System.out.println(product.label());
    }

    public static Object of(String name, int price) {
        if ("Oil".equals(name)) {
            return  getLiquidationProduct(name, price);
        }
        return new Product(name, price);
    }

    private static LiquidationProduct getLiquidationProduct(String name, int price) {
         return (LiquidationProduct) liquidationProduct;

    }
}