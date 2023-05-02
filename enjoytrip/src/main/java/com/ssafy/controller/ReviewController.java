package com.ssafy.controller;


import com.ssafy.service.ReviewService;
import com.ssafy.vo.Notice;
import com.ssafy.vo.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping(value = "/reviews/user/{userId}")
    public List<Review> selectByUserId(@PathVariable String userId) {
        List<Review> list = reviewService.selectByUserId(userId);
        return list;
    }

    @GetMapping(value = "/reviews/attraction/{attractionId}")
    public List<Review> selectByAttraction(@PathVariable String attractionId) {
        List<Review> list = reviewService.selectByAttraction(attractionId);
        return list;
    }

    @GetMapping(value = "/reviews/{id}")
    public Review selectOne(@PathVariable String id) {
        Review review = reviewService.selectOne(id);
        return review;
    }

    @PostMapping(value = "/reviews")
    public int insert(@RequestBody Review review) {
        return reviewService.insert(review);
    }

    @PutMapping(value = "/reviews")
    public int update(@RequestBody Review review) {
        return reviewService.update(review);
    }

    @DeleteMapping(value = "/reviews/{id}")
    public int delete(@PathVariable String id) {
        return reviewService.delete(id);
    }
}
