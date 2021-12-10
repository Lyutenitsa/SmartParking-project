package com.sioux.smartparkingapp.Repo;

import com.sioux.smartparkingapp.models.Appointment;
import com.sioux.smartparkingapp.models.Manager;
import com.sioux.smartparkingapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    List<Manager> findByName(String name);
    List<Manager> findByEmail(String email);

}
