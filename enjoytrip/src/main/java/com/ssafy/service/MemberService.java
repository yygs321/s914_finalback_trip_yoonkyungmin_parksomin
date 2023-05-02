package com.ssafy.service;

import com.ssafy.vo.Member;

import java.util.List;

public interface MemberService {

    public List<Member> selectAll();

    public Member selectOne(String id);
    public int insert(Member member);
    public int update(Member member);
    public int delete(String id);
}
