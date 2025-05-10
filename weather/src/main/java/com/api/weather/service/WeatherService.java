package com.api.weather.service;

import com.api.weather.dto.WeatherApiDto;
import com.api.weather.dto.WeatherDto;
import com.api.weather.mapper.WeatherMapper;
import com.api.weather.model.Weather;
import com.api.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final WeatherRepository weatherRepository;
    private final String apiKey;

    public WeatherService(RestTemplate restTemplate,
                          WeatherRepository weatherRepository,
                          @Value("${weather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.weatherRepository = weatherRepository;
        this.apiKey = apiKey;
    }

    @Cacheable(value = "weather", key = "#city")
    public WeatherDto getWeather(String city) {
        try {
            String BASE_URL = "http://api.weatherstack.com/";
            String url = BASE_URL + "current?access_key=" + apiKey + "&query=" + city;

            WeatherApiDto response = restTemplate.getForObject(url, WeatherApiDto.class);

            Weather weather = WeatherMapper.INSTANCE.toEntity(response);

            weatherRepository.save(weather);
            return WeatherMapper.INSTANCE.toDto(weather);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Erro ao consultar a API de clima", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro inesperado ao consultar a API de clima", e);
        }
    }
}