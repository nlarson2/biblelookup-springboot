package com.larson.biblelookup.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.larson.biblelookup.Exception.VerseNotFoundException;
import com.larson.biblelookup.Models.Bible;
import com.larson.biblelookup.Models.Book;
import com.larson.biblelookup.Models.Verse;
import com.larson.biblelookup.Repositories.BibleRepository;
import com.larson.biblelookup.Repositories.BookRepository;
import com.larson.biblelookup.Repositories.VerseRepository;
import com.larson.biblelookup.dto.VerseCreationRequest;
import com.larson.biblelookup.dto.VerseListRequest;
import com.larson.biblelookup.dto.VerseListResponse;
import com.larson.biblelookup.dto.VerseSingleRequest;
import com.larson.biblelookup.dto.VerseSingleResponse;

@Service
public class VerseService {
    private final VerseRepository verseRepository;
    private final BibleRepository bibleRepository;
    private final BookRepository bookRepository;

    public VerseService(VerseRepository verseRepository, BibleRepository bibleRepository, BookRepository bookRepository) {
        this.verseRepository=verseRepository;
        this.bibleRepository=bibleRepository;
        this.bookRepository=bookRepository;
    }

    public Verse createVerse(VerseCreationRequest verseRequest) {
        Bible bible = bibleRepository.findByName(verseRequest.getBibleName())
                    .orElseGet(()->{
                        Bible newBible = new Bible(verseRequest.getBibleName());
                        return bibleRepository.save(newBible);
                    });
        Book book = bookRepository.findByName(verseRequest.getBookName())
                    .orElseGet(()->{
                        Book newBook = new Book(verseRequest.getBookName());
                        return bookRepository.save(newBook);
                    });

        Verse verse = new Verse(bible, book, verseRequest.getChapterNum(), verseRequest.getVerseNum(), verseRequest.getScripture());
        return verseRepository.save(verse);

    }

    public VerseSingleResponse getSingleVerse(VerseSingleRequest verseRequest) {

        String bibleName = verseRequest.getBibleName();
        String bookName = verseRequest.getBookName();
        Integer chapterNum = verseRequest.getChapterNum();
        Integer verseNum = verseRequest.getVerseNum();

        Bible bible = bibleRepository.findByName(bibleName).orElseThrow(
            () -> new ResourceNotFoundException("Bible \""+ bibleName +"\" not found"));

        Book book = bookRepository.findByName(bookName).orElseThrow(
            () -> new ResourceNotFoundException("Book  \""+ bookName +"\" not found"));

        Verse verse = verseRepository.findByChapterVerse(bible, book, chapterNum, verseNum).orElseThrow(
            () -> new VerseNotFoundException(String.format("Verse reference does not exist: %s %s %d:%d", bibleName, bookName, chapterNum, verseNum)));
        
        VerseSingleResponse response = new VerseSingleResponse();
        response.setBibleName(bibleName);
        response.setBookName(bookName);
        response.setChapterNum(chapterNum);
        response.setVerseNum(verseNum);
        response.setVerse(verse.getScripture());
        return response;
    }

    public VerseListResponse getManyVerses(VerseListRequest verseRequest) {

        String bibleName = verseRequest.getBibleName();
        String bookName = verseRequest.getBookName();
        Integer chapterNum = verseRequest.getChapterNum();
        Integer verseNumStart = verseRequest.getVerseNumStart();
        Integer veresNumEnd = verseRequest.getVerseNumEnd();

        Bible bible = bibleRepository.findByName(bibleName).orElseThrow(
            () -> new ResourceNotFoundException("Bible \""+ bibleName +"\" not found"));

        Book book = bookRepository.findByName(bookName).orElseThrow(
            () -> new ResourceNotFoundException("Book  \""+ bookName +"\" not found"));
        
        List<Verse> verses =  verseRepository.findVersesByBibleBookChaterVerseRange(bible, book, chapterNum, verseNumStart, veresNumEnd);
        List<String> verseStrings = verses.stream().map(Verse::getScripture).collect(Collectors.toList());

        if(verseStrings.isEmpty()) {
            throw new VerseNotFoundException(String.format("Verse reference does not exist: %s %s %d:%d-%d", bibleName, bookName, chapterNum, verseNumStart, veresNumEnd));
        }

        VerseListResponse response = new VerseListResponse();
        response.setBibleName(bibleName);
        response.setBookName(bookName);
        response.setChapterNum(chapterNum);
        response.setVerseStart(verseNumStart);
        response.setVerses(verseStrings.toArray(new String[0]));
        return response;
        
    }
}
