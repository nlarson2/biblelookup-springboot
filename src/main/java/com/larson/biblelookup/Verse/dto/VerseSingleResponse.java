package com.larson.biblelookup.Verse.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VerseSingleResponse {
    private String bibleName;
    private String bookName;
    private Integer chapterNum;
    private Integer verseNum;
    private String verse;
}
