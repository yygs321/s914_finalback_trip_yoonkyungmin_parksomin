package com.ssafy.service;

import com.ssafy.vo.Member;

public interface MemberService {

    public Member selectOne(String num);
    public int insert(Member member);
    public int update(Member member);
    public int delete(String num);
}
