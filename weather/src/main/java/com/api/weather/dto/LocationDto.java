package com.api.weather.dto;

public record LocationDto(
        String name,
        String country,
        String region,
        String timezone_id,
        String localtime
) {
    public String getLocaltime() {
        return localtime;
    }
}