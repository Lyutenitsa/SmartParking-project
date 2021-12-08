package com.sioux.smartparkingapp.Repo;

import com.sioux.smartparkingapp.models.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

    Boolean existsByOccupied(Boolean occupied);

    List<ParkingSpot>findByOccupied(Boolean occupied);
}
