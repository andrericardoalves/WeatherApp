package com.hackerrank.sample.controller;


import com.hackerrank.sample.mapper.WeatherMapper;
import com.hackerrank.sample.model.Weather;
import com.hackerrank.sample.resquest.WeatherRequest;
import com.hackerrank.sample.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @PostMapping
    public ResponseEntity<Weather> insert(@RequestBody @Valid WeatherRequest weatherRequest){
       Weather weather =  Optional.of(weatherRequest).map(WeatherMapper::weatherRequestToWeather).get();
       Optional<Weather> weatherResponse = service.insert(weather);
       return ResponseEntity.status(HttpStatus.CREATED).body(weatherResponse.get()) ;
    }

    @GetMapping
    public ResponseEntity<List<Weather>> select(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findOrderById().get());
    }
}
