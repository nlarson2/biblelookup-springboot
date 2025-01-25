package com.larson.versesearch.Models;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="verses")
@Getter
@Setter
@NamedQuery(name = "Verse.findByChapterVerse",
  query = "select v from Verse v where v.bible = ?1 and v.book = ?2 and v.chapterNum = ?3 and v.verseNum = ?4")
@NamedQuery(name = "Verse.findVersesByBibleBookChaterVerseRange",
  query = "select v from Verse v where v.bible = ?1 and v.book = ?2 and v.chapterNum = ?3 and v.verseNum >= ?4 and v.verseNum <= ?5")
public class Verse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    
    private Integer chapterNum;
    private Integer verseNum;
    @Column(columnDefinition = "TEXT")
    private String scripture;
    
    @ManyToOne
    @JoinColumn(name="FK bibleId")
    private Bible bible;

    @ManyToOne
    @JoinColumn(name="FK bookId")
    private Book book;

    private Verse() {}
    public Verse(Bible bible, Book book, Integer chapterNum, Integer verseNum, String scripture) {
        this.bible=bible;this.book=book;
        this.chapterNum=chapterNum;this.verseNum=verseNum;this.scripture=scripture;
    }
}
