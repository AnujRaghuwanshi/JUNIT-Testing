package com.example.CRUDApplication.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
    private Main main;
    private List<Weather> weather;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Main{
        @JsonProperty("temp")
        private double temp;
        @JsonProperty("humidity")
        private int humidity;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Weather{
        @JsonProperty("description")
        private String description;
    }
}
