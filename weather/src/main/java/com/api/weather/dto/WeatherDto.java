package com.api.weather.dto;

public record WeatherDto(
        String city,
        String region,
        String country,
        Integer temperature,
        String timezoneId,
        String localtime
) {
}