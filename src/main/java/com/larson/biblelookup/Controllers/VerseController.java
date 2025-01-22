package com.larson.biblelookup.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.larson.biblelookup.Exception.BibleNotFoundException;
import com.larson.biblelookup.Exception.VerseNotFoundException;
import com.larson.biblelookup.Models.Verse;
import com.larson.biblelookup.Services.VerseService;
import com.larson.biblelookup.dto.VerseCreationRequest;
import com.larson.biblelookup.dto.VerseListRequest;
import com.larson.biblelookup.dto.VerseListResponse;
import com.larson.biblelookup.dto.VerseSingleRequest;
import com.larson.biblelookup.dto.VerseSingleResponse;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
public class VerseController {

    private final VerseService verseService;

    @PostMapping("/verses")
    public ResponseEntity<Verse> createVerse(@RequestBody VerseCreationRequest verseRequest) {
        Verse createdVerse = verseService.createVerse(verseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVerse);
    }
    
    @GetMapping("/verse")
    public ResponseEntity<VerseSingleResponse> getSingleVerse(
        @ModelAttribute VerseSingleRequest verseRequest
    ) {       
        VerseSingleResponse verse = verseService.getSingleVerse(verseRequest);
        return ResponseEntity.status(HttpStatus.FOUND).body(verse);
    }

    @GetMapping("/verses")
    public ResponseEntity<VerseListResponse> getManyVerses(
        @ModelAttribute VerseListRequest verseRequest
    ) {       
        VerseListResponse verses = verseService.getManyVerses(verseRequest);
        return ResponseEntity.status(HttpStatus.FOUND).body(verses);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleVerseNotFound(Exception ex) {
        String reason = ex.getMessage(); // Assuming your exception has a custom message
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(reason);
    }
       
}
