package com.ssafy.controller;


import com.ssafy.service.BoardService;
import com.ssafy.service.QnAService;
import com.ssafy.vo.QnA;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QnAController {

    private final QnAService qnaService;

    @GetMapping(value = "/qna")
    public List<QnA> selectAll() {
        return qnaService.selectAll();
    }

    @GetMapping(value = "/qna/{id}")
    public QnA selectOne(@PathVariable String id) {
        return qnaService.selectOne(id);
    }

    @PostMapping(value = "/qna")
    public int insert(@RequestBody QnA qnA) {
        return qnaService.insert(qnA);
    }

    @PutMapping(value = "/qna")
    public int update(@RequestBody QnA qnA) {
        return qnaService.update(qnA);
    }

    @DeleteMapping(value = "/qna/{id}")
    public int delete(@PathVariable String id) {
        return qnaService.delete(id);
    }
}
