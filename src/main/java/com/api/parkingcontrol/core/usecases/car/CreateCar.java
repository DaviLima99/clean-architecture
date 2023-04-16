package com.api.parkingcontrol.core.usecases.car;

import com.api.parkingcontrol.core.domain.model.Car;
import com.api.parkingcontrol.core.domain.repositories.CarRepository;
import com.api.parkingcontrol.core.domain.repositories.UseCase;
import lombok.Builder;
import lombok.Value;

public class CreateCar extends UseCase<CreateCar.InputValues, CreateCar.OutputValues> {
    private CarRepository carRepository;

    public CreateCar(CarRepository movieRepository) {
        this.carRepository = movieRepository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        Car car = Car.builder()
                .withModel(input.getModel())
                .withCarParking(input.getCarParking())
                .withLicensePlate(input.getLicensePlate())
                .withPlan(input.getPlan()).build();

        return OutputValues.builder()
                .withCar(carRepository.createCar(car)).build();
    }

    @Value
    @Builder(builderClassName = "Builder", setterPrefix = "with")
    public static class InputValues implements UseCase.InputValues {
        String model;
        String licensePlate;
        String plan;
        String carParking;
    }

    @Value
    @Builder(builderClassName = "Builder", setterPrefix = "with")
    public static class OutputValues implements UseCase.OutputValues {
        Car car;
    }
}
