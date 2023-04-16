package com.api.parkingcontrol.data.presenter.controllers.car;

import com.api.parkingcontrol.core.domain.repositories.UseCaseExecutor;
import com.api.parkingcontrol.core.usecases.car.CreateCar;
import com.api.parkingcontrol.data.presenter.entity.CarRequestModel;
import com.api.parkingcontrol.data.presenter.entity.CarResponseModel;
import com.api.parkingcontrol.data.presenter.mapper.CarMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class CarController implements CarResource{
    private final UseCaseExecutor useCaseExecutor;
    private final CarMapper carMapper;
    private final CreateCar createMovie;

    CarController(UseCaseExecutor useCaseExecutor,
                  CarMapper carMapper,
                  CreateCar createMovie) {
        this.useCaseExecutor = useCaseExecutor;
        this.carMapper = carMapper;
        this.createMovie = createMovie;
    }

    @Override
    public CompletableFuture<CarResponseModel> createCar(@RequestBody CarRequestModel carRequestModel) {
        return useCaseExecutor.execute(
            createMovie,
            CreateCar.InputValues.builder()
                    .withCarParking(carRequestModel.getCarParking())
                    .withModel(carRequestModel.getModel())
                    .withLicensePlate(carRequestModel.getLicensePlate())
                    .withPlan(carRequestModel.getPlan())
                    .withModel(carRequestModel.getModel())
                    .build(),
            (outputValues) -> carMapper.convertEntityToResponse(outputValues.getCar())
        );
    }

    @Override
    public CompletableFuture<List<CarResponseModel>> getCars() {
        return null;
    }
}
