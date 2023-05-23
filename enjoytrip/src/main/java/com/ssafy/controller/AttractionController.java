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

    @GetMapping(value = "/attractions/search/{keyword}")
    public List<Attraction> selectArea(@PathVariable("keyword") String keyword) {
        List<Attraction> list = attractionService.selectArea(keyword);
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

    @GetMapping(value = "/attractions/weather")
    public List<Weather> crawlingWeather(@RequestParam("sido") String sido, @RequestParam("gugun") String gugun){
        return attractionService.crawlingWeather(sido, gugun);
    }


}
