package com.company;

public class Book {
    protected int bookId;
    protected int catId;
    protected String ISBN;
    protected String title;
    protected String author;
    protected float price;
    protected String descrip;

    public void Book (int bookId, int catId, String ISBN, String title, String author, float price, String descrip) {
        this.bookId = bookId;
        this.catId = catId;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.descrip = descrip;
    }
}
