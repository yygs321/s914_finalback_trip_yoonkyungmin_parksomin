package com.ssafy.controller;

import com.ssafy.service.AttractionService;
import com.ssafy.vo.Attraction;
import com.ssafy.vo.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class AttractionController {

    private final AttractionService attractionService;

    @GetMapping(value = "/attractions/top")
    public List<Attraction> selectTopAttractions() {
        List<Attraction> list = attractionService.selectTopAttractions();
        return list;
    }

    @GetMapping(value = "/attractions/search/keyword/{keyword}")
    public List<Attraction> selectArea(@PathVariable("keyword") String keyword) {
        List<Attraction> list = attractionService.selectArea(keyword);
        return list;
    }

    @GetMapping(value = "/attractions/search/category/{contentTypeId}")
    public List<Attraction> selectByContentType(@PathVariable("contentTypeId") String contentTypeId) {
        System.out.println("category!!!!");
        List<Attraction> list = attractionService.selectByContentType(contentTypeId);
        return list;
    }

    @GetMapping(value = "/attractions/search")
    public List<Attraction> selectArea(@RequestParam("keyword") String keyword, @RequestParam("contentTypeId") String contentTypeId) {
        return attractionService.selectCategory(keyword, contentTypeId);
    }

    @GetMapping(value = "/attractions/{contentId}")
    public Attraction selectOne(@PathVariable("contentId") String contentId) {
        return attractionService.selectAttraction(contentId);
    }

    @GetMapping(value = "/attractions/weather")
    public List<Weather> crawlingWeather(@RequestParam("sido") String sido, @RequestParam("gugun") String gugun){
        return attractionService.crawlingWeather(sido, gugun);
    }


}
