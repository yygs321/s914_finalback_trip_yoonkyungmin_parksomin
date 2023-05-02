package com.ssafy.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String comment_id;
    private String qna_id;
    private String user_id;
    private String qna_comment;
}
