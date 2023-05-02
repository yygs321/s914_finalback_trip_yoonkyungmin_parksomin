package com.ssafy.service;


import com.ssafy.vo.Board;

import java.util.List;

public interface BoardService {
    public List<Board> selectAll();

    public Board selectOne(String id);
    public int insert(Board board);
    public int update(Board board);
    public int delete(String id);
}
