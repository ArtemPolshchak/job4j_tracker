package ru.job4j.pojo;

public class
Book {
    private String nameOfBook;
    private String bookAuthor;

    public Book(String nameOfBook, String bookAuthor) {
        this.nameOfBook = nameOfBook;
        this.bookAuthor = bookAuthor;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public Book setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
        return this;
    }

    public Book setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
        return this;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

}
