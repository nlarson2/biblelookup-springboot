package com.larson.biblelookup.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.larson.biblelookup.Models.Bible;
import com.larson.biblelookup.Models.Book;
import com.larson.biblelookup.Models.Verse;
import com.larson.biblelookup.Repositories.BibleRepository;
import com.larson.biblelookup.Repositories.BookRepository;
import com.larson.biblelookup.Repositories.VerseRepository;
import com.larson.biblelookup.Services.VerseService;
import com.larson.biblelookup.dto.VerseCreationRequest;
import com.larson.biblelookup.dto.VerseListRequest;
import com.larson.biblelookup.dto.VerseListResponse;
import com.larson.biblelookup.dto.VerseSingleRequest;
import com.larson.biblelookup.dto.VerseSingleResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
public class VerseController {

    private final BibleRepository bibleRepository;
    private final BookRepository bookRepository;
    private final VerseRepository verseRepository;
    private final VerseService verseService;

    @PostMapping("/verses")
    public ResponseEntity<Verse> createVerse(@RequestBody VerseCreationRequest verseRequest) {
        Verse createdVerse = verseService.createVerse(verseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVerse);
    }

    @GetMapping("/{bible}/{book}/{chapter}/{verse}")
    public ResponseEntity<Verse> getSingleVerse(
        @PathVariable("bible") String bibleName, 
        @PathVariable("book") String bookName, 
        @PathVariable("chapter") int chapterNum,
        @PathVariable("verse") int verseNum,
        @RequestParam String param
    ) {

        Bible bible = bibleRepository.findByName(bibleName).orElseThrow(
            () -> new ResourceNotFoundException("Bible \""+ bibleName +"\" not found"));

        Book book = bookRepository.findByName(bookName).orElseThrow(
            () -> new ResourceNotFoundException("Book  \""+ bookName +"\" not found"));

        Verse verse = verseRepository.findByChapterVerse(bible, book, chapterNum, verseNum).orElseThrow(
            () -> new ResourceNotFoundException(String.format("Verse \"%s %s %d:%d\" not found ",bibleName, bookName, chapterNum, verseNum)));

        return ResponseEntity.status(HttpStatus.FOUND).body(verse);
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
