package com.vivekanandpv.springbootcqrskafkademo.services;

import com.vivekanandpv.springbootcqrskafkademo.models.Weather;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WeatherService {
    private final KafkaPublisherService kafkaPublisherService;

    public WeatherService(KafkaPublisherService kafkaPublisherService) {
        this.kafkaPublisherService = kafkaPublisherService;
    }

    public Weather getWeather(String city) {
        Random r = new Random();

        double t1 = r.nextDouble(-10, 50);
        double t2 = r.nextDouble(-10, 50);

        Weather weather = new Weather(
                city,
                Math.min(t1, t2),
                Math.max(t1, t2),
                r.nextInt(30, 200)
        );

        kafkaPublisherService.publish(weather);

        return weather;
    }
}
