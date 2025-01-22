package com.larson.biblelookup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
 public class VerseSingleRequest {
    private String bibleName;
    private String bookName;
    private Integer chapterNum;
    private Integer verseNum;
    private String verse;
}
