package com.ssafy.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {

    private String bookmarkId;
    private String userId;
    private String contentId;
}
