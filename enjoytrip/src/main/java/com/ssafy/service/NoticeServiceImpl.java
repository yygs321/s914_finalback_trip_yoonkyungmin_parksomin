package com.ssafy.service;

import com.ssafy.vo.Notice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{
    @Override
    public List<Notice> selectAll() {
        return null;
    }

    @Override
    public Notice selectOne(String id) {
        return null;
    }

    @Override
    public int insert(Notice notice) {
        return 0;
    }

    @Override
    public int update(Notice notice) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
