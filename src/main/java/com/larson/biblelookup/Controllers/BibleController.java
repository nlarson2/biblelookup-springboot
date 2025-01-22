package com.larson.biblelookup.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.larson.biblelookup.Models.Bible;
import com.larson.biblelookup.Repositories.BibleRepository;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
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
