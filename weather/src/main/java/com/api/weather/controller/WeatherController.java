package com.api.weather.controller;

import com.api.weather.dto.WeatherDto;
import com.api.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/{city}")
    @ResponseStatus(HttpStatus.OK)
    public WeatherDto getWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }
}