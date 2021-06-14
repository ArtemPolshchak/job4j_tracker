package ru.job4j.pojo;

public class Library {
    public static <books> void main(String[] args) {
        Book cleanCode = new Book("Чистый Код", "Роберт Мартин");
        Book javaPhilosophy = new Book("Философия Java", "Брюс Эккель");
        Book javaCompleteGuide = new Book("Java Полное Руководство", "Герберт Шилдт");
        Book rockingAlgorithms = new Book("Грокаем Алгоритмы", "Адитья Бхаргава");

        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = javaPhilosophy;
        books[2] = javaCompleteGuide;
        books[3] = rockingAlgorithms;

        for (Book arrayBook : books) {
            System.out.println(arrayBook.getNameOfBook() + " - " + arrayBook.getBookAuthor());
        }
        System.out.println();

            Book[] tmp = new Book[1];
            tmp[0] = books[3];
            books[3] = books[0];
            books[0] = tmp[0];

        for (Book arrayBook : books) {
            System.out.println(arrayBook.getNameOfBook() + " - " + arrayBook.getBookAuthor());
        }

        System.out.println();

        for (Book book : books) {
            if (book.getNameOfBook().equals("Чистый Код")) {
                System.out.println(book.getNameOfBook() + " - " + book.getBookAuthor());
                break;
            }
        }

        }
    }

