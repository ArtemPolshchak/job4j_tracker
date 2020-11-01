package ru.job4j.pojo;

public class Library {
    public static <books> void main(String[] args) {
        Book CleanCode = new Book("Чистый Код", "Роберт Мартин" );
        Book JavaPhilosophy = new Book("Философия Java", "Брюс Эккель");
        Book JavaCompleteGuide = new Book("Java Полное Руководство", "Герберт Шилдт");
        Book RockingAlgorithms = new Book("Грокаем Алгоритмы", "Адитья Бхаргава");

        Book[] books = new Book[4];
        books[0] = CleanCode;
        books[1] = JavaPhilosophy;
        books[2] = JavaCompleteGuide;
        books[3] = RockingAlgorithms;

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

        for (int i = 0; i < books.length; i++) {
            if (books[i].getNameOfBook().equals("Чистый Код")) {
                System.out.println(books[i].getNameOfBook() + " - " + books[i].getBookAuthor());
                break;
            }

        }

        }
    }

