package com.ssafy.controller;


import com.ssafy.service.BoardService;
import com.ssafy.service.QnAService;
import com.ssafy.vo.QnA;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QnAController {


    private final BoardService<QnA> qnaService;


    @GetMapping(value = "/qnas")
    public List<QnA> selectAll() {
        return qnaService.selectAll();
    }

    @GetMapping(value = "/qnas/{id}")
    public QnA selectOne(@PathVariable String id) {
        return qnaService.selectOne(id);
    }

    @PostMapping(value = "/qnas")
    public int insert(@RequestBody QnA qna) {
        return qnaService.insert(qna);
    }

    @PutMapping(value = "/qnas")
    public int update(@RequestBody QnA qna) {
        return qnaService.update(qna);
    }

    @DeleteMapping(value = "/qnas/{id}")
    public int delete(@PathVariable String id) {
        return qnaService.delete(id);
    }
}
