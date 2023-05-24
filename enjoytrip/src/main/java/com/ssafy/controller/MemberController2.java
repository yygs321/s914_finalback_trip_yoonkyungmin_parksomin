package com.ssafy.controller;

import com.ssafy.service.MemberService2;
import com.ssafy.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {


    private final MemberService2 memberService2;

    @GetMapping(value = "/members")
    public List<Member> selectAll() {
        return memberService2.selectAll();
    }

    //회원정보조회
    @GetMapping(value="/members/{id}")
    public Member selectOne(@PathVariable String id) {
        return memberService2.selectOne(id);
    }

    @PostMapping(value="/members")
    public int insert(@RequestBody Member member) {
        return memberService2.insert(member);
    }

    @PutMapping(value = "/members")
    public int update(@RequestBody Member member) {
        return memberService2.update(member);
    }

    @DeleteMapping(value = "/members/{id}")
    public int delete(@PathVariable String id) {
        return memberService2.delete(id);
    }
}
