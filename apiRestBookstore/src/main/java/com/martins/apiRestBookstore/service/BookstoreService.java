package com.martins.apiRestBookstore.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.martins.apiRestBookstore.domain.Book;

@Service
public class BookstoreService {
    private final ArrayList<Book> books = new ArrayList<>();
    private long idCounter = 1;

    public void addBook(Book book) {
        book.setId(idCounter);
        books.add(book);
        idCounter++;
    }

    public String getBooksTitle() {
        String titles = "";
        for (Book book : books) {
            titles += book.getTitle() + ", ";
        }
        return titles;
    }

    public Book getBookById(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new IllegalArgumentException("Book with id " + id + " not found.");
    }

    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new IllegalArgumentException("Book with title " + title + " not found.");
    }

    public void removeBook(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return;
            }
        }
        throw new IllegalArgumentException("Book with id " + id + " not found.");
    }

}
