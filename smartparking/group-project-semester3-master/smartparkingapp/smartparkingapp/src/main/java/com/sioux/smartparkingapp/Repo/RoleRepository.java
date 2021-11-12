package com.sioux.smartparkingapp.Repo;

import com.sioux.smartparkingapp.models.ERole;
import com.sioux.smartparkingapp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}