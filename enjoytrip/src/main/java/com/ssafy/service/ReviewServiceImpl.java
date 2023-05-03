package com.ssafy.service;

import com.ssafy.mapper.AttractionMapper;
import com.ssafy.mapper.ReviewMapper;
import com.ssafy.vo.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewMapper mapper;
    private final AttractionMapper attractionMapper;
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
        int res = mapper.insert(review);
        attractionMapper.updateRating(review.getContentId());
        return res;
    }

    @Override
    public int update(Review review) {
        int res = mapper.update(review);
        attractionMapper.updateRating(review.getContentId());
        return res;
    }

    @Override
    public int delete(String id, String contentId) {
        int res = mapper.delete(id);
        attractionMapper.updateRating(contentId);
        return res;
    }
}
