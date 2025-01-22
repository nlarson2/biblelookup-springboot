package com.larson.biblelookup.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.larson.biblelookup.Models.Bible;
import com.larson.biblelookup.Models.Book;
import com.larson.biblelookup.Repositories.BibleRepository;
import com.larson.biblelookup.Repositories.BookRepository;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


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
