package com.ssafy.controller;


import com.ssafy.service.NoticeService;
import com.ssafy.service.QnAService;
import com.ssafy.vo.Notice;
import com.ssafy.vo.QnA;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;


    @GetMapping(value = "/notices")
    public List<Notice> selectAll() {
        List<Notice> qna=noticeService.selectAll();
        for (Notice q: qna) {
            System.out.println("123");

            System.out.println(q.getTitle());
        }
        return noticeService.selectAll();
    }

    @GetMapping(value = "/notices/{id}")
    public Notice selectOne(@PathVariable String id) {
        Notice notice = noticeService.selectOne(id);
        return notice;
    }

    @PostMapping(value = "/notices")
    public int insert(@RequestBody Notice notice) {
        return noticeService.insert(notice);
    }

    @PutMapping(value = "/notices")
    public int update(@RequestBody Notice notice) {
        return noticeService.update(notice);
    }

    @DeleteMapping(value = "/notices/{id}")
    public int delete(@PathVariable String id) {
        return noticeService.delete(id);
    }
}
