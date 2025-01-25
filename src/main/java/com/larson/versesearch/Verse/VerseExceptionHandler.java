package com.larson.versesearch.Verse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.larson.versesearch.Exception.VerseNotFoundException;
import com.larson.versesearch.Exception.VerseRequestFormattingException;

@RestControllerAdvice
public class VerseExceptionHandler {
    
    @ExceptionHandler(VerseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String verseNotFoundHandler(VerseNotFoundException ex) {
        return String.format("ERROR MESSAGE: %s",ex.getMessage());
    }

    @ExceptionHandler(VerseRequestFormattingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String verseRequestFormattingExceptionHandler(VerseRequestFormattingException ex) {
        return String.format("ERROR MESSAGE: %s",ex.getMessage());
    }

}
