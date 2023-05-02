package com.ssafy.mapper;


import java.util.List;

public interface BoardMapper<T> {
    public List<T> selectAll();

    public T selectOne(String id);
    public int insert(T t);
    public int update(T t);
    public int delete(String id);
}
