package com.parking.api.infrastructure.repositories.subscription;

import com.parking.api.infrastructure.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSubscriptionRepository extends JpaRepository<SubscriptionEntity, String> {
}
