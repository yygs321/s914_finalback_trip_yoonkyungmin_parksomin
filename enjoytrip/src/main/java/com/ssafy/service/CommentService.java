package com.ssafy.service;


import com.ssafy.vo.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> selectAll();
    public Comment selectOne(String id);

    public List<Comment> selectGroup(String id);
    public int insert(Comment comment);
    public int update(Comment comment);
    public int delete(String id);
}
