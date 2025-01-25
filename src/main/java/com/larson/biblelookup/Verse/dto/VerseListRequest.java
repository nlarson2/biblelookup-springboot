package com.larson.biblelookup.Verse.dto;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VerseListRequest {
    private String bibleName;
    private String bookName;
    private Integer chapterNum;
    private Integer verseNumStart;
    private Optional<Integer> verseNumEnd;
}
