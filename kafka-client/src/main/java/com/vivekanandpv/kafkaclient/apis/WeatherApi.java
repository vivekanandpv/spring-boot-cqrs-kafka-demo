package com.vivekanandpv.kafkaclient.apis;

import com.vivekanandpv.kafkaclient.models.Weather;
import com.vivekanandpv.kafkaclient.repositories.WeatherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherApi {
    private final WeatherRepository weatherRepository;

    public WeatherApi(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @GetMapping
    public ResponseEntity<List<Weather>> get() {
        return ResponseEntity.ok(weatherRepository.findAll());
    }

    @GetMapping("recent")
    public ResponseEntity<Weather> getRecent() {
        return ResponseEntity.ok(weatherRepository.findAll().getLast());
    }
}
