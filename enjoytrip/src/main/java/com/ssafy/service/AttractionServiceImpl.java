package com.ssafy.service;

import com.ssafy.mapper.AttractionMapper;
import com.ssafy.vo.Area;
import com.ssafy.vo.Attraction;
import com.ssafy.vo.Weather;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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

    @Override
    public List<Weather> crawlingWeather(String sido, String gugun) {
        Area area = mapper.selectAreaName(sido, gugun);
        List<Weather> list = new ArrayList<>();

        try {
            // Jsoup을 사용하여 네이버 날씨 페이지에 접속
            Document doc = Jsoup.connect("https://search.naver.com/search.naver?query=" + area.getSidoName() + " " + area.getGugunName() + " 날씨").get();

            // 날씨 정보를 담고 있는 요소들 선택
            Elements weatherElements = doc.select(".week_item");

            // 날씨 정보 출력
            for (Element element : weatherElements) {
                Weather weather = new Weather();
                Elements icons = element.select(".wt_icon");
                Element temperature = element.selectFirst(".cell_temperature");
                String date = element.select(".cell_date").text();
                weather.setDay(date);

                for (int i = 0; i < 2; i++) {
                    String fileURL = "https://ssl.pstatic.net/sstatic/keypage/outside/scui/weather_overseas/img/icon_weather/icon_flat_";
                    Element icon = icons.get(i);
                    icon.removeClass("wt_icon");
                    if (i == 0){
                        weather.setAmImg(fileURL + icon.className().substring(4) + ".svg");
                        weather.setLowTemperature(temperature.select(".lowest").text().substring(4));
                    }
                    else{
                        weather.setPmImg(fileURL + icon.className().substring(4) + ".svg");
                        weather.setHighTemperature(temperature.select(".highest").text().substring(4));
                    }
                }
                list.add(weather);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
