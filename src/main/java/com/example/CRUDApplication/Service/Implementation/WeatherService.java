package com.example.CRUDApplication.Service.Implementation;

import com.example.CRUDApplication.api.response.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherService {

    @Value("${weather.api.key}")
    private String apikey;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeatherByCity(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather"
                + "?q=" + city + "&appid=" + apikey + "&units=metric";

        WeatherResponse res = null;
        try {
            res = restTemplate.getForObject(url, WeatherResponse.class);
        } catch (Exception e) {
            log.error("Weather api failed", e);
        }
        return res;
    }
}
