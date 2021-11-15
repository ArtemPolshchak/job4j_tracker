package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {

        products[index] = null;
        while (products[products.length - 1] != null) {
            products[index] = products[index + 1];
            products[index + 1 ] = null;
            index++;
        }
        return  products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);

        for (Product product : products) {
            System.out.println(product.getName());
        }
        products[1] = null;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

    }
}
