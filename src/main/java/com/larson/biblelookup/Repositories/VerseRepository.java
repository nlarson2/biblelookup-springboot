package com.larson.biblelookup.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.larson.biblelookup.Models.Bible;
import com.larson.biblelookup.Models.Book;
import com.larson.biblelookup.Models.Verse;

public interface VerseRepository extends CrudRepository<Verse, Integer>{

    Optional<Verse> findByChapterVerse(Bible bible, Book book, Integer chapter, Integer verse);
    
    List<Verse> findVersesByBibleBookChaterVerseRange(Bible bible, Book book, Integer chapter, Integer verseStart, Integer verseEnd);
}