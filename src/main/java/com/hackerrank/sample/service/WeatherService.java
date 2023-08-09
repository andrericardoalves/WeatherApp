package com.hackerrank.sample.service;

import com.hackerrank.sample.model.Weather;

import java.util.List;
import java.util.Optional;

public interface WeatherService {

    public Optional<Weather> insert(Weather weather);

    public Optional<List<Weather>> findOrderById();
}
