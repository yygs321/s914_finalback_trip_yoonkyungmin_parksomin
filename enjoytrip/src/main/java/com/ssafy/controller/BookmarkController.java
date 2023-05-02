package com.ssafy.controller;


import com.ssafy.service.BookmarkService;
import com.ssafy.vo.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;


    @GetMapping(value = "/bookmarks")
    public List<Bookmark> selectAll() {
        return bookmarkService.selectAll();
    }

    @PostMapping(value = "/bookmarks")
    public int insert() {
        return bookmarkService.insert();
    }

    @DeleteMapping(value = "/bookmarks/{id}")
    public int delete(@PathVariable String id) {
        return bookmarkService.delete(id);
    }
}
