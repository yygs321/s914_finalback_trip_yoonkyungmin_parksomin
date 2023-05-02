package com.ssafy.service;


import com.ssafy.vo.Review;

import java.util.List;

public interface ReviewService {
    public List<Review> selectByUserId(String userId);

    public Review selectOne(String id);

    public List<Review> selectByAttraction(String attractionId);

    public int insert(Review review);


    public int update(Review review);

    public int delete(String id);
}
