package com.ssafy.service;

import com.ssafy.mapper.AttractionMapper;
import com.ssafy.vo.Attraction;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttractionServiceImpl implements AttractionService{

    private final AttractionMapper mapper;

    @Override
    public List<Attraction> selectTopAttractions() {
        return mapper.selectTopAttractions();
    }

    @Override
    public List<Attraction> selectArea(String sidoCode) {
        return mapper.selectArea(sidoCode);
    }

    @Override
    public List<Attraction> selectCategory(String sidoCode, String contentType) {
        Map<String, String> map = new HashMap<>();
        map.put("sidoCode", sidoCode);
        map.put("contentType", contentType);
        return mapper.selectCategory(map);
    }

    @Override
    public Attraction selectAttraction(String contentId) {
        mapper.updateReadCount(contentId);
        return mapper.selectAttraction(contentId);
    }
}
