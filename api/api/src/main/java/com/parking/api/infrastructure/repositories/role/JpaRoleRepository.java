package com.parking.api.infrastructure.repositories.role;

import com.parking.api.infrastructure.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoleRepository extends JpaRepository<RoleEntity, String> {
}
