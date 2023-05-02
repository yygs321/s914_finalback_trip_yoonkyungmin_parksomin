package com.ssafy.mapper;

import com.ssafy.vo.Attraction;
import com.ssafy.vo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    public List<Notice> selectAll();

    public Notice selectOne(String id);
    public int insert(Notice notice);
    public int update(Notice notice);
    public int delete(String id);
}
