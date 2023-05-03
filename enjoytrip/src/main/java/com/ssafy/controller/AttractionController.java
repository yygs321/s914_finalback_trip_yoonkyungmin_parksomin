package com.ssafy.controller;

import com.ssafy.service.AttractionService;
import com.ssafy.vo.Attraction;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AttractionController {

    private final AttractionService attractionService;

    @GetMapping(value = "/attractions/search/{sido}")
    public List<Attraction> selectArea(@PathVariable("sido") String sidoCode) {
        List<Attraction> list = attractionService.selectArea(sidoCode);
        return list;
    }

    @GetMapping(value = "/attractions/search")
    public List<Attraction> selectArea(@RequestParam("sido") String sidoCode, @RequestParam("contentTypeId") String contentType) {
        return attractionService.selectCategory(sidoCode, contentType);
    }

    @GetMapping(value = "/attractions/{contentId}")
    public Attraction selectOne(@PathVariable("contentId") String contentId) {
        return attractionService.selectAttraction(contentId);
    }


}
