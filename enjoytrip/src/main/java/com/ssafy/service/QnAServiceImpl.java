package com.ssafy.service;

import com.ssafy.mapper.QnAMapper;
import com.ssafy.vo.QnA;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnAServiceImpl implements BoardService<QnA>{

    private final QnAMapper qnaMapper;


    @Override
    public List<QnA> selectAll() {
        return qnaMapper.selectAll();
    }

    @Override
    public QnA selectOne(String id) {
        return qnaMapper.selectOne(id);
    }

    @Override
    public int insert(QnA qna) {
        return qnaMapper.insert(qna);
    }

    @Override
    public int update(QnA qna) {
        return qnaMapper.update(qna);
    }

    @Override
    public int delete(String id) {
        return qnaMapper.delete(id);
    }
}
