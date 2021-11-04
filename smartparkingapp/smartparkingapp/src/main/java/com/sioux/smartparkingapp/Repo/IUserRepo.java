package com.sioux.smartparkingapp.Repo;

import com.sioux.smartparkingapp.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<Appointment, Long> {

}
