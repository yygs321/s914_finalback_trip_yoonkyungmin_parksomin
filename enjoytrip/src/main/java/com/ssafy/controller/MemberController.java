package com.ssafy.controller;

import com.ssafy.service.MemberService;
import com.ssafy.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;

    @GetMapping(value = "/members")
    public List<Member> selectAll() {
        return memberService.selectAll();
    }

    //회원정보조회
    @GetMapping(value="/members/{id}")
    public Member selectOne(@PathVariable String id) {
        return memberService.selectOne(id);
    }

    @PostMapping(value="/members")
    public int insert(@RequestBody Member member) {
        return memberService.insert(member);
    }

    @PutMapping(value = "/members")
    public int update(@RequestBody Member member) {
        return memberService.update(member);
    }

    @DeleteMapping(value = "/members/{id}")
    public int delete(@PathVariable String id) {
        return memberService.delete(id);
    }
}
