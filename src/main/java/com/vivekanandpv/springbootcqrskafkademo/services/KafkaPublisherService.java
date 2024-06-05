package com.vivekanandpv.springbootcqrskafkademo.services;

import com.vivekanandpv.springbootcqrskafkademo.models.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisherService {
    private final KafkaTemplate<String,Object> kafkaTemplate;
    private final String topicName;

    public KafkaPublisherService(KafkaTemplate<String, Object> kafkaTemplate, @Value("${topic.name}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void publish(Weather weatherModel) {
        kafkaTemplate.send(topicName, weatherModel);
    }
}
