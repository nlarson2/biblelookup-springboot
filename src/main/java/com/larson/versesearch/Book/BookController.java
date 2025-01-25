package com.larson.versesearch.Book;

import org.springframework.web.bind.annotation.RestController;

import com.larson.versesearch.Models.Book;
import com.larson.versesearch.Repositories.BookRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
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
