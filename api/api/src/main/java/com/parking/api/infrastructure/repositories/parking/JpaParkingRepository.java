package com.parking.api.infrastructure.repositories.parking;

import com.parking.api.infrastructure.entities.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaParkingRepository extends JpaRepository<ParkingEntity, String> {
}
