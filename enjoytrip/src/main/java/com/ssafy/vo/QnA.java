package com.ssafy.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QnA{

    private String qna_id;
    private String qna_title;
    private String qna_content;
    private String user_id;
    private String secret;

}
