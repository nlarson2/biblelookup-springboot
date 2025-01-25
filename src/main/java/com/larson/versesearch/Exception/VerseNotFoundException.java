package com.larson.versesearch.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Verse not found")
public class VerseNotFoundException extends RuntimeException {
    public VerseNotFoundException(String message) {
        super(message);
    }
}