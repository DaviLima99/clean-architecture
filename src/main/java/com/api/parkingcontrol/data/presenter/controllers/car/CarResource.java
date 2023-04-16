package com.api.parkingcontrol.data.presenter.controllers.car;

import com.api.parkingcontrol.data.presenter.entity.CarRequestModel;
import com.api.parkingcontrol.data.presenter.entity.CarResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/car")
public interface CarResource {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CompletableFuture<CarResponseModel> createCar(@RequestBody CarRequestModel carRequestModel);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    CompletableFuture<List<CarResponseModel>> getCars();

}
