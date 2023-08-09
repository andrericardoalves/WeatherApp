package com.hackerrank.sample.repository;

import com.hackerrank.sample.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}
