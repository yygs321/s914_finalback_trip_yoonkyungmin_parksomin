package com.ssafy.controller;

import com.ssafy.service.CommentService;
import com.ssafy.vo.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping(value="/comments")
    public List<Comment> selectAll() {
        return commentService.selectAll();
    }

    @GetMapping(value="/comments/{id}")
    public Comment selectOne(@PathVariable String id) {
        return commentService.selectOne(id);
    }

    @GetMapping(value="/comments/qna/{id}")
    public List<Comment> selectByContent(@PathVariable String id) {
        return commentService.selectByContent(id);
    }

    @PostMapping(value="/comments")
    public int insert(@RequestBody Comment comment) {
        return commentService.insert(comment);
    }

    @PutMapping(value="/comments")
    public int update(@RequestBody Comment comment) {
        return commentService.update(comment);
    }

    @DeleteMapping(value="/comments/{id}")
    public int delete(@PathVariable String id) {
        return commentService.delete(id);
    }
}
