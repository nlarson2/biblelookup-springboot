package com.larson.biblelookup.Verse.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerseCreationRequest {
    private String bibleName;
    private String bookName;
    private Integer chapterNum;
    private Integer verseNum;
    private String scripture;
    // Getters and Setters
}
