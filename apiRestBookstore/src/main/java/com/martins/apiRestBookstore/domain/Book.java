package com.martins.apiRestBookstore.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private long id;
    private String title;
    private String author;
    private double price;
    private String date;

    public Book(String title, String author, double price, String date) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.date = date;
    }
}
