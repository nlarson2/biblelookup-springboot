package com.larson.versesearch.Bible;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.larson.versesearch.Exception.BibleNotFoundException;

@RestControllerAdvice
public class BibleNotFoundAdvice {
    
    @ExceptionHandler(BibleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String bibleNotFoundHandler(BibleNotFoundException ex) {
        return String.format("ERROR MESSAGE: %s",ex.getMessage());
    }

}
