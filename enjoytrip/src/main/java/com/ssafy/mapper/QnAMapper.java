package com.ssafy.mapper;


import com.ssafy.vo.QnA;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnAMapper{

    public List<QnA> selectAll();

    public QnA selectOne(String id);

    public int insert(QnA qnA);


    public int update(QnA qnA);

    public int delete(String id);
}
