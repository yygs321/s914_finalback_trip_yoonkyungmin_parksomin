package com.ssafy.controller;


import com.ssafy.service.BoardService;
import com.ssafy.vo.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final BoardService<Notice> noticeService;

    @CrossOrigin("*")
    @GetMapping(value = "/notices")
    public List<Notice> selectAll() {
        List<Notice> list=noticeService.selectAll();
        return list;
    }

    @CrossOrigin("*")
    @GetMapping(value = "/notices/{id}")
    public Notice selectOne(@PathVariable String id) {
        Notice notice = noticeService.selectOne(id);
        return notice;
    }


    @CrossOrigin("*")
    @PostMapping(value = "/insertNotices")
    public int insert(@RequestBody Notice notice) {
        return noticeService.insert(notice);
    }

    @CrossOrigin("*")
    @PutMapping(value = "/notices/{id}")
    public int update(@RequestBody Notice notice) {
        return noticeService.update(notice);
    }

    @CrossOrigin("*")
    @DeleteMapping(value = "/notices/{id}")
    public int delete(@PathVariable String id) {
        return noticeService.delete(id);
    }
}
