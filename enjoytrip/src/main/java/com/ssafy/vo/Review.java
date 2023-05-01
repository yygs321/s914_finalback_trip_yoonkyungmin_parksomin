package com.ssafy.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private String reviewId;
    private String userId;
    private String contentId;
    private String reviewContent;
    private String rating;
    private String image;
}
