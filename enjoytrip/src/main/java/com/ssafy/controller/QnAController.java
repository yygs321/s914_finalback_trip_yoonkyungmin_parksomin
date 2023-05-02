package com.ssafy.controller;


import com.ssafy.service.QnAService;
import com.ssafy.vo.QnA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QnAController {

    @Autowired
    QnAService qnaService;


    @GetMapping(value = "/qna")
    public List<QnA> selectAll() {
        List<QnA> qna=qnaService.selectAll();
        for (QnA q: qna) {
            System.out.println("123");

            System.out.println(q.getQna_title());
        }
        return qnaService.selectAll();
    }

    @GetMapping(value = "/qna/{id}")
    public QnA selectOne(@PathVariable String id) {
        QnA q=qnaService.selectOne(id);
        System.out.println(q);
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
