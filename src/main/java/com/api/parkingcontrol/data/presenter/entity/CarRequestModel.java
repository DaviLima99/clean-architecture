package com.api.parkingcontrol.data.presenter.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName =  "Builder", setterPrefix = "with")
@JsonDeserialize(builder = CarRequestModel.Builder.class)
public class CarRequestModel {
    String model;
    String licensePlate;
    String plan;
    String carParking;
}
