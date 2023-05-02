package com.ssafy.mapper;

import com.ssafy.vo.Attraction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttractionMapper {
    public List<Attraction> selectArea(String sidoCode);
    public List<Attraction> selectCategory(Map<String, String> map);
}
