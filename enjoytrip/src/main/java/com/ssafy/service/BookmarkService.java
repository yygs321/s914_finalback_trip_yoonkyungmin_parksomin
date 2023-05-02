package com.ssafy.service;



import com.ssafy.vo.Bookmark;

import java.util.List;

public interface BookmarkService {
    public List<Bookmark> selectAll();
    public int insert();
    public int delete(String id);
}
