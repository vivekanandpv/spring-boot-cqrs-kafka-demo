package com.vivekanandpv.kafkaclient.repositories;

import com.vivekanandpv.kafkaclient.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
