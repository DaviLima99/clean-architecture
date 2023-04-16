package com.api.parkingcontrol.data.presenter.mapper;

import com.api.parkingcontrol.core.domain.model.Car;
import com.api.parkingcontrol.data.presenter.entity.CarResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NameTransformers;
import org.modelmapper.convention.NamingConventions;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final ModelMapper modelMapper;

    public CarMapper() {
        ModelMapper modelMapper = new ModelMapper();
        Configuration builderConfiguration = modelMapper.getConfiguration().copy()
                .setDestinationNameTransformer(NameTransformers.builder("with"))
                .setDestinationNamingConvention(NamingConventions.builder("with"));
        modelMapper.createTypeMap(Car.class, CarResponseModel.Builder.class, builderConfiguration);
        this.modelMapper = modelMapper;
    }

    public CarResponseModel convertEntityToResponse(Car entity) {
        return this.modelMapper.map(entity, CarResponseModel.Builder.class).build();
    }
}
