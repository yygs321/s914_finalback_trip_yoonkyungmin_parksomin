package com.ssafy.service;

import com.ssafy.mapper.BookmarkMapper;
import com.ssafy.vo.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService{

    @Autowired
    BookmarkMapper bookmarkMapper;

    @Override
    public List<Bookmark> selectAll() {
        return bookmarkMapper.selectAll();
    }

    @Override
    public int insert() {
        return bookmarkMapper.insert();
    }

    @Override
    public int delete(String id) {
        return bookmarkMapper.delete(id);
    }
}
