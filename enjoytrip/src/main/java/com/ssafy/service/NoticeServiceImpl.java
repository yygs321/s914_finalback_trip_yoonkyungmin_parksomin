package com.ssafy.service;

import com.ssafy.mapper.NoticeMapper;
import com.ssafy.vo.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements BoardService<Notice>{

    private final NoticeMapper mapper;
    @Override
    public List<Notice> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Notice selectOne(String id) {
        return mapper.selectOne(id);
    }

    @Override
    public int insert(Notice notice) {
        return mapper.insert(notice);
    }

    @Override
    public int update(Notice notice) {
        return mapper.update(notice);
    }

    @Override
    public int delete(String id) {
        return mapper.delete(id);
    }
}
