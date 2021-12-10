package com.sioux.smartparkingapp.services;

import com.sioux.smartparkingapp.Repo.ParkingSpotRepository;
import com.sioux.smartparkingapp.models.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public void update
}
