package com.api.parkingcontrol.config;

import com.api.parkingcontrol.core.domain.repositories.CarRepository;
import com.api.parkingcontrol.data.datasources.CarEntityRepository;
import com.api.parkingcontrol.data.repositories.CarRepositoryImpl;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    @Bean
    public CarRepository circularRepository(Logger logger, CarEntityRepository circularEntityRepository) {
        return new CarRepositoryImpl(logger, circularEntityRepository);
    }
}
