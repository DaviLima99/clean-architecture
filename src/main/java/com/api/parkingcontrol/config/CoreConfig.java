package com.api.parkingcontrol.config;

import com.api.parkingcontrol.core.domain.repositories.CarRepository;
import com.api.parkingcontrol.core.usecases.car.CreateCar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {
    @Bean
    public CreateCar createCircularUseCase(CarRepository repository) {
        return new CreateCar(repository);
    }
}
