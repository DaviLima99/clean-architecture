package com.api.parkingcontrol.core.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", setterPrefix = "with")
public class Car {
    int id;
    String model;
    String licensePlate;
    String plan;
    String carParking;
}
