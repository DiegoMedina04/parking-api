package com.parking.api.infrastructure.repositories.plan;

import com.parking.api.infrastructure.entities.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPlanRepository extends JpaRepository<PlanEntity, String> {
}
