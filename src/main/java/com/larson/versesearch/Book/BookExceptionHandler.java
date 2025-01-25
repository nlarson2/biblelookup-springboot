package com.larson.versesearch.Book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.larson.versesearch.Exception.BookNotFoundException;

@RestControllerAdvice
public class BookExceptionHandler {
    
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String bookNotFoundHandler(BookNotFoundException ex) {
        return String.format("ERROR MESSAGE: %s",ex.getMessage());
    }

}
