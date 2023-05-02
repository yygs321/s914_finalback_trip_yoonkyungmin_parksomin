package com.ssafy.mapper;

import com.ssafy.vo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public List<Member> selectAll();
    public Member selectOne(String id);
    public int insert(Member member);
    public int update(Member member);
    public int delete(String id);
}
