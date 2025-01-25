package com.larson.versesearch.Bible;

import org.springframework.web.bind.annotation.RestController;

import com.larson.versesearch.Models.Bible;
import com.larson.versesearch.Repositories.BibleRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class BibleController {

    private final BibleRepository bibleRepository;


    public BibleController(BibleRepository bibleRepository) {
        this.bibleRepository=bibleRepository;
    }

     @GetMapping("/bibles")
    public Iterable<Bible> findAllBibles() {
        return this.bibleRepository.findAll();
    }

    @PostMapping("/bibles")
    public Bible addOneBible(@RequestBody Bible bible) {
        return this.bibleRepository.save(bible);
    }
    
}
