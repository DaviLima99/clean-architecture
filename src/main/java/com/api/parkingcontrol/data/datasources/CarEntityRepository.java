package com.api.parkingcontrol.data.datasources;

import com.api.parkingcontrol.data.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CarEntityRepository extends CrudRepository<CarEntity, String> {
}
