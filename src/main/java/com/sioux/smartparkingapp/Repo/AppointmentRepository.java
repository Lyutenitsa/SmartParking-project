package com.sioux.smartparkingapp.Repo;

import com.sioux.smartparkingapp.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long> {
    Boolean existsByLicensePlate(String licencePlate);
    Optional<Appointment> findByLicensePlate(String licencePlate);
}
