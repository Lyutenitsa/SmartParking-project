package com.sioux.smartparkingapp.services;

import com.sioux.smartparkingapp.Repo.ParkingSpotRepository;
import com.sioux.smartparkingapp.models.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSpotRepository spotRepository;

    public List<ParkingSpot> findAvailableList()
    {

        List<ParkingSpot> available = spotRepository.findByOccupied(false);
        if(available.isEmpty()){
            return null;
        }
        else{
            return available;
        }
    }

    public Boolean checkForEmptySpot()
    {
        Boolean empty = spotRepository.existsByOccupied(false);

        return empty;
    }

    public Boolean updateOccupancyById(Long id){

        Optional<ParkingSpot> dbParkingSpot = spotRepository.findById(id);



        if(dbParkingSpot.isPresent()){

            ParkingSpot parkingSpot = dbParkingSpot.get();
            Boolean occupancy = parkingSpot.getOccupied();
            System.out.println(occupancy);

            parkingSpot.setOccupied(!occupancy);

            spotRepository.save(parkingSpot);

            return true;
        }
        else
        {
            System.out.println("Parking id not found");
            return false;
        }


    }

    public Boolean updateOccupancy(ParkingSpot parkingSpot){

        boolean dbParkingSpot = spotRepository.existsById(parkingSpot.getParkingSpot_id());

        if(dbParkingSpot){

            Boolean occupancy = parkingSpot.getOccupied();

            System.out.println("occupied = "+ occupancy);
            parkingSpot.setOccupied(occupancy);

            spotRepository.save(parkingSpot);

            return true;
        }
        else
        {
            System.out.println("Parking id not found");
            return false;
        }


    }
}
