package com.ssafy.service;

import com.ssafy.mapper.BookmarkMapper;
import com.ssafy.vo.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService{

    private final BookmarkMapper bookmarkMapper;

    @Override
    public List<Bookmark> selectAll() {
        return bookmarkMapper.selectAll();
    }

    @Override
    public int insert(Bookmark bookmark) {
        return bookmarkMapper.insert(bookmark);
    }

    @Override
    public int delete(Bookmark bookmark) {
        return bookmarkMapper.delete(bookmark);
    }
}
