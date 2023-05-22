package com.ssafy.mapper;

import com.ssafy.vo.Area;
import com.ssafy.vo.Attraction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttractionMapper {

    public List<Attraction> selectTopAttractions();
    public List<Attraction> selectArea(String sidoCode);
    public List<Attraction> selectCategory(Map<String, String> map);

    public Attraction selectAttraction(String contentId);

    public void updateBookmarkCount(String contentId);
    public void deleteBookmarkCount(String contentId);

    public void updateReadCount(String contentId);

    public void updateRating(String contentId);

    public Area selectAreaName(String sido, String gugun);
}
