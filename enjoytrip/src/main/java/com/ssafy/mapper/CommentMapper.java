package com.ssafy.mapper;


import com.ssafy.vo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public List<Comment> selectAll();

    public Comment selectOne(String id);

    public List<Comment> selectByContent(String id);

    public int insert(Comment comment);


    public int update(Comment comment);

    public int delete(String id);
}
