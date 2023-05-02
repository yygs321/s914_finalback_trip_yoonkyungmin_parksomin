package com.ssafy.service;



import com.ssafy.vo.Bookmark;

import java.util.List;

public interface BookmarkService {
    public List<Bookmark> selectAll();
    public List<Bookmark> selectByUser(String id);
    public List<Bookmark> selectByContent(String id);
    public int insert(Bookmark bookmark);
    public int delete(Bookmark bookmark);
}
