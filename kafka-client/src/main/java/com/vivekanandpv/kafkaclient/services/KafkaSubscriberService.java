package com.vivekanandpv.kafkaclient.services;

import com.google.gson.Gson;
import com.vivekanandpv.kafkaclient.models.Weather;
import com.vivekanandpv.kafkaclient.repositories.WeatherRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaSubscriberService {
    private final WeatherRepository weatherRepository;

    private final Logger logger;

    public KafkaSubscriberService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    @KafkaListener(topics = "kafka-cqrs-demo", groupId = "user-group")
    public void saveWeatherData(String data) {
        Gson gson = new Gson();
        Weather weather = gson.fromJson(data, Weather.class);
        weatherRepository.saveAndFlush(weather);
    }
}
