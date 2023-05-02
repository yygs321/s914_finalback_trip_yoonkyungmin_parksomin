package com.ssafy.service;


import com.ssafy.vo.Board;

import java.util.List;

public interface BoardService<T> {
    public List<T> selectAll();

    public T selectOne(String id);
    public int insert(T t);
    public int update(T t);
    public int delete(String id);
}
