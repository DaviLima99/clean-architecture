package com.api.parkingcontrol.core.domain.repositories;

import com.api.parkingcontrol.core.domain.model.Car;

import java.util.List;

public interface CarRepository {
    public Car createCar(Car car);
    public void deleteCar(int id);
    public Car getCar(int id);
    public List<Car> getCars();
}
