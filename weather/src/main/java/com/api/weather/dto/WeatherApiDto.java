package com.api.weather.dto;

public record WeatherApiDto(
        LocationDto location,
        CurrentDto current
) {
}