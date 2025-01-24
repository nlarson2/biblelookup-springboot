package com.larson.biblelookup.Book;

import org.springframework.web.bind.annotation.RestController;

import com.larson.biblelookup.Models.Book;
import com.larson.biblelookup.Repositories.BookRepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

     @GetMapping("/books")
    public Iterable<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    @PostMapping("/books")
    public Book addOneBook(@RequestBody Book book) {
        return this.bookRepository.save(book);
    }

       
}
