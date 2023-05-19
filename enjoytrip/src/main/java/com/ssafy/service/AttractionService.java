package com.ssafy.service;

import com.ssafy.vo.Attraction;
import com.ssafy.vo.Member;

import java.util.List;

public interface AttractionService {

    public List<Attraction> selectTopAttractions();
    public List<Attraction> selectArea(String sidoCode);

    public List<Attraction> selectCategory(String sidoCode, String contentType);

    public Attraction selectAttraction(String contentId);
}
