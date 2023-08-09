package com.hackerrank.sample.service.impl;

import com.hackerrank.sample.model.Weather;
import com.hackerrank.sample.repository.WeatherRepository;
import com.hackerrank.sample.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository repository;

    @Override
    public Optional<Weather> insert(Weather weather) {
        return Optional.of(repository.save(weather)) ;
    }


    public Optional<List<Weather>> findOrderById() {
        return Optional.of(repository.findAll(Sort.by(Sort.Direction.ASC,"id")));
    }
}
