package com.ssafy.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {

    private String id;
    private String email;
    private String pass;
    private String name;

    private String address;
    private String grade;
}
