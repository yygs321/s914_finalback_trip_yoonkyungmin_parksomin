package com.ssafy.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    private String sidoCode;
    private String gugunCode;
    private String sido;
    private String gugun;
    private String day;
    private String amImg;
    private String pmImg;
    private String amWeather;
    private String pmWeather;
    private String lowTemperature;
    private String highTemperature;



}
