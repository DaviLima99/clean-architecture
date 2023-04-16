package com.api.parkingcontrol.data.presenter.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName =  "Builder", setterPrefix = "with")
@JsonDeserialize(builder = CarResponseModel.Builder.class)
public class CarResponseModel {
    int id;
    String model;
    String licensePlate;
    String plan;
    String carParking;
}
