package com.api.parkingcontrol.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"model", "plan", "carParking", "licensePlate"})
@Builder(builderClassName = "Builder", setterPrefix = "with", toBuilder = true)
@Entity
public class CarEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String model;
    String licensePlate;
    String plan;
    String carParking;
}
