package com.ssafy.mapper;


import com.ssafy.vo.Comment;
import com.ssafy.vo.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    public List<Review> selectByUserId(String userId);

    public Review selectOne(String id);

    public List<Review> selectByAttraction(String attractionId);

    public int insert(Review review);


    public int update(Review review);

    public int delete(String id);
}
