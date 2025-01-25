package com.larson.versesearch.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Request Fomatting Error")
public class VerseRequestFormattingException extends RuntimeException {
    public VerseRequestFormattingException(String message) {
        super(message);
    }
}