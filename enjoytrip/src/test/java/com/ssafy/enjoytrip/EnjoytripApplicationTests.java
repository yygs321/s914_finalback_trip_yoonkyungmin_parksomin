package com.ssafy.enjoytrip;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EnjoytripApplicationTests {

	@Test
	void crawling(){
		try {
			String area = "제주특별자치도 서귀포시 남원읍";
			// Jsoup을 사용하여 네이버 날씨 페이지에 접속
			Document doc = Jsoup.connect("https://search.naver.com/search.naver?query=" + area + " 날씨").get();

			// 날씨 정보를 담고 있는 요소들 선택
			Elements weatherElements = doc.select(".week_item");

			// 날씨 정보 출력
			for (Element element : weatherElements) {
				Elements icons = element.select(".wt_icon");
				List<String> iconList = new ArrayList<>();
				for (Element icon : icons) {
					icon.removeClass("wt_icon");
					iconList.add(icon.classNames().toString());
				}
				String date = element.select(".cell_date").text();
				String weather = element.select(".cell_weather").text();
				String temperature = element.select(".cell_temperature").text();
				for (String s : iconList) {
					System.out.println(s);
				}

				System.out.println("날짜: " + date);
				System.out.println("날씨: " + weather);
				System.out.println("온도: " + temperature);
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void contextLoads() {
	}

}
