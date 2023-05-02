package com.ssafy.service;

import com.ssafy.mapper.MemberMapper;
import com.ssafy.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<Member> selectAll() {
        return memberMapper.selectAll();
    }

    @Override
    public Member selectOne(String id) {
        return memberMapper.selectOne(id);
    }

    @Override
    public int insert(Member member) {
        return memberMapper.insert(member);
    }

    @Override
    public int update(Member member) {
        return memberMapper.update(member);
    }

    @Override
    public int delete(String id) {
        return memberMapper.delete(id);
    }
}
