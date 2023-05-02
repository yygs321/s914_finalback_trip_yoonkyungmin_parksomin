package com.ssafy.service;

import com.ssafy.mapper.ReviewMapper;
import com.ssafy.vo.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewMapper mapper;
    @Override
    public List<Review> selectByUserId(String userId) {
        return mapper.selectByUserId(userId);
    }

    @Override
    public Review selectOne(String id) {
        return mapper.selectOne(id);
    }

    @Override
    public List<Review> selectByAttraction(String attractionId) {
        return mapper.selectByAttraction(attractionId);
    }

    @Override
    public int insert(Review review) {
        return mapper.insert(review);
    }

    @Override
    public int update(Review review) {
        return mapper.update(review);
    }

    @Override
    public int delete(String id) {
        return mapper.delete(id);
    }
}
