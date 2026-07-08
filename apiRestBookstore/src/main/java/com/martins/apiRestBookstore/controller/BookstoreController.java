package com.martins.apiRestBookstore.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.martins.apiRestBookstore.domain.Book;
import com.martins.apiRestBookstore.service.BookstoreService;

@RestController
@RequestMapping("/bookstore")
public class BookstoreController {
    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @PostMapping()
    public String addBook(@RequestBody Book book) {
        bookstoreService.addBook(book);
        return "Book added!";
    }

    @GetMapping()
    public String getBooksTitle() {
        return bookstoreService.getBooksTitle();
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable long id) {
        return bookstoreService.getBookById(id).getTitle();
    }

    @GetMapping("/search")
    public String getBookByTitle(@RequestParam String title) {
        return bookstoreService.getBookByTitle(title).getTitle();
    }

    @DeleteMapping("/{id}")
    public String removeBook(@PathVariable long id) {
        bookstoreService.removeBook(id);
        return "Book removed!";
    }

}
