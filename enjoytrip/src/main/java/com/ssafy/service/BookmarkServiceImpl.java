package com.ssafy.service;

import com.ssafy.mapper.AttractionMapper;
import com.ssafy.mapper.BookmarkMapper;
import com.ssafy.vo.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService{

    private final BookmarkMapper bookmarkMapper;
    private final AttractionMapper attractionMapper;

    @Override
    public List<Bookmark> selectAll() {
        return bookmarkMapper.selectAll();
    }

    @Override
    public List<Bookmark> selectByUser(String id) {
        return bookmarkMapper.selectByUser(id);
    }

    @Override
    public List<Bookmark> selectByContent(String id) {
        return bookmarkMapper.selectByContent(id);
    }

    @Override
    public int insert(Bookmark bookmark) {
        String contentId=bookmark.getContentId();
        attractionMapper.updateBookmarkCount(contentId);
        return bookmarkMapper.insert(bookmark);
    }

    @Override
    public int delete(Bookmark bookmark) {
        String contentId=bookmark.getContentId();
        attractionMapper.deleteBookmarkCount(contentId);
        return bookmarkMapper.delete(bookmark);
    }
}
