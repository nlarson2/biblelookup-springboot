package com.larson.versesearch.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.larson.versesearch.Models.Bible;
import com.larson.versesearch.Models.Book;
import com.larson.versesearch.Models.Verse;

public interface VerseRepository extends JpaRepository<Verse, Integer>{

    Optional<Verse> findByChapterVerse(Bible bible, Book book, Integer chapter, Integer verse);
    
    List<Verse> findVersesByBibleBookChaterVerseRange(Bible bible, Book book, Integer chapter, Integer verseStart, Integer verseEnd);
}