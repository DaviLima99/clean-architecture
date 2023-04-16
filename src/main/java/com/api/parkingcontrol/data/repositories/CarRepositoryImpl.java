package com.api.parkingcontrol.data.repositories;

import com.api.parkingcontrol.data.datasources.CarEntityRepository;
import com.api.parkingcontrol.data.entity.CarEntity;
import com.api.parkingcontrol.core.domain.model.Car;
import com.api.parkingcontrol.core.domain.repositories.CarRepository;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CarRepositoryImpl implements CarRepository {

    final CarEntityRepository datasourceLocal;
    private Logger logger;

    public CarRepositoryImpl(Logger logger, CarEntityRepository movieDatasourceLocal) {
        this.datasourceLocal = movieDatasourceLocal;
        this.logger = logger;
    }

    @Override
    public Car createCar(Car car) {
        logger.info("create ({})", car);

        CarEntity entity = CarEntity.builder()
                .withModel(car.getModel())
                .withPlan(car.getPlan())
                .withLicensePlate(car.getLicensePlate())
                .withCarParking(car.getCarParking())
                .build();

        CarEntity saved = datasourceLocal.save(entity);

        System.out.println("............................................");
        System.out.println(entity);
        System.out.println("===========================================");


        return Car.builder()
                .withId(saved.getId())
                .withCarParking(saved.getCarParking())
                .withLicensePlate(saved.getLicensePlate())
                .withModel(saved.getModel())
                .withPlan(saved.getPlan())
                .build();
    }

    @Override
    public void deleteCar(int id) {

    }

    @Override
    public Car getCar(int id) {
        return null;
    }

    @Override
    public List<Car> getCars() {
        List<Car> existing = StreamSupport.stream(datasourceLocal.findAll().spliterator(), false)
                .map(t -> Car.builder()
                        .withId(t.getId())
                        .withModel(t.getModel())
                        .withPlan(t.getPlan())
                        .withCarParking(t.getCarParking())
                        .withLicensePlate(t.getLicensePlate())
                        .build()
                ).collect(Collectors.toList());

        logger.info("getCars(): {}", existing);
        return existing;
    }
}
