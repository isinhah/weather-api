package com.api.weather.mapper;

import com.api.weather.dto.WeatherApiDto;
import com.api.weather.dto.WeatherDto;
import com.api.weather.model.Weather;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper
public interface WeatherMapper {

    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "city", source = "location.name")
    @Mapping(target = "region", source = "location.region")
    @Mapping(target = "country", source = "location.country")
    @Mapping(target = "temperature", source = "current.temperature")
    @Mapping(target = "timezoneId", source = "location.timezone_id")
    @Mapping(target = "localtime", expression = "java(parseLocalDateTime(response.location().getLocaltime()))")
    Weather toEntity(WeatherApiDto response);

    @Mapping(target = "localtime", expression = "java(formatLocalDateTime(weather.getLocaltime()))")
    WeatherDto toDto(Weather weather);

    default LocalDateTime parseLocalDateTime(String localtime) {
        if (localtime == null || localtime.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(localtime, formatter);
    }

    default String formatLocalDateTime(LocalDateTime localtime) {
        if (localtime == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return localtime.format(formatter);
    }
}