package com.larson.biblelookup.Verse.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VerseListRequest {
    private String bibleName;
    private String bookName;
    private Integer chapterNum;
    private Integer verseNumStart;
    private Integer verseNumEnd;
}
