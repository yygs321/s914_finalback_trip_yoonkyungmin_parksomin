package com.ssafy.mapper;

import com.ssafy.vo.Bookmark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookmarkMapper {
    public List<Bookmark> selectAll();
    public int insert(Bookmark bookmark);
    public int delete(Bookmark bookmark);
}
