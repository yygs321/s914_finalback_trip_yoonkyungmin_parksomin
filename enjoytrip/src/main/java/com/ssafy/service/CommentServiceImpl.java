package com.ssafy.service;

import com.ssafy.mapper.CommentMapper;
import com.ssafy.vo.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentMapper commentMapper;

    @Override
    public List<Comment> selectAll() {
        return commentMapper.selectAll();
    }

    @Override
    public Comment selectOne(String id) {
        return commentMapper.selectOne(id);
    }

    //qna별 comment
    @Override
    public List<Comment> selectByContent(String id) {
        return commentMapper.selectByContent(id);
    }

    @Override
    public int insert(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public int update(Comment comment) {
        return commentMapper.update(comment);
    }

    @Override
    public int delete(String id) {
        return commentMapper.delete(id);
    }
}
