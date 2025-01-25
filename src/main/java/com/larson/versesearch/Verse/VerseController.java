package com.larson.versesearch.Verse;

import org.springframework.web.bind.annotation.RestController;

import com.larson.versesearch.Models.Verse;
import com.larson.versesearch.Verse.dto.VerseCreationRequest;
import com.larson.versesearch.Verse.dto.VerseListRequest;
import com.larson.versesearch.Verse.dto.VerseListResponse;
import com.larson.versesearch.Verse.dto.VerseSingleRequest;
import com.larson.versesearch.Verse.dto.VerseSingleResponse;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
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
}
