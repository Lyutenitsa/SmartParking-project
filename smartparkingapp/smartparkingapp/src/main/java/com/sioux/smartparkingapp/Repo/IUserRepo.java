package com.sioux.smartparkingapp.Repo;

import com.sioux.smartparkingapp.models.Appointment;
import com.sioux.smartparkingapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String Username);
}

