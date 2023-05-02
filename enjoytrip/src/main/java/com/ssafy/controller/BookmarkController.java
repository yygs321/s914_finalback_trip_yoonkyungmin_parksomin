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


    @GetMapping(value="/bookmarks/user/{id}")
    public List<Bookmark> selectByUser(@PathVariable String id) {
        return bookmarkService.selectByUser(id);
    }

    @GetMapping(value="/bookmarks/content/{id}")
    public List<Bookmark> selectByContent(@PathVariable String id) {
        return bookmarkService.selectByContent(id);
    }

    @PostMapping(value = "/bookmarks")
    public int insert(@RequestBody Bookmark bookmark) {
        return bookmarkService.insert(bookmark);
    }

    @DeleteMapping(value = "/bookmarks")
    public int delete(@RequestBody Bookmark bookmark) {
        return bookmarkService.delete(bookmark);
    }
}
