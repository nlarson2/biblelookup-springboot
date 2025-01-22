package com.larson.biblelookup.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Bible not found")
public class BibleNotFoundException extends RuntimeException {
    public BibleNotFoundException(String message) {
        super(message);
    }
}