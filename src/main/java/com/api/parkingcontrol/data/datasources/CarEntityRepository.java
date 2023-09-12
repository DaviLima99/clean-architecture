package com.api.parkingcontrol.data.datasources;

import com.api.parkingcontrol.data.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;

public interface CarEntityRepository extends CrudRepository<CarEntity, String> {
}
