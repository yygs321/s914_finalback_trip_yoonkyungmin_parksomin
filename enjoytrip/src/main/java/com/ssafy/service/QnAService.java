package com.ssafy.service;


import com.ssafy.vo.QnA;

import java.util.List;

public interface QnAService {
    public List<QnA> selectAll();

    public QnA selectOne(String id);
    public int insert(QnA qna);
    public int update(QnA qna);
    public int delete(String id);
}
