package com.hackerrank.sample.mapper;


import com.hackerrank.sample.model.Weather;
import com.hackerrank.sample.resquest.WeatherRequest;

public class WeatherMapper {

    public static Weather weatherRequestToWeather(WeatherRequest weatherRequest){
        return Weather.builder()
                .location(weatherRequest.getLocation())
                .temperature(weatherRequest.getTemperature())
                .date(weatherRequest.getDate())
                .build();
    }
}
