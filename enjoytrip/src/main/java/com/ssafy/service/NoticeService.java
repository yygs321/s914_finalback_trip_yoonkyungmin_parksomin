package com.ssafy.service;


import com.ssafy.vo.Notice;
import com.ssafy.vo.QnA;

import java.util.List;

public interface NoticeService {
    public List<Notice> selectAll();

    public Notice selectOne(String id);
    public int insert(Notice notice);
    public int update(Notice notice);
    public int delete(String id);
}
