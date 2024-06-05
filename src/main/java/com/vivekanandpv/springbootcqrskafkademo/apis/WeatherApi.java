package com.vivekanandpv.springbootcqrskafkademo.apis;

import com.vivekanandpv.springbootcqrskafkademo.models.Weather;
import com.vivekanandpv.springbootcqrskafkademo.services.KafkaPublisherService;
import com.vivekanandpv.springbootcqrskafkademo.services.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherApi {
    private final WeatherService weatherService;

    public WeatherApi(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("by-city/{city}")
    public ResponseEntity<Weather> get(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeather(city));
    }
}
