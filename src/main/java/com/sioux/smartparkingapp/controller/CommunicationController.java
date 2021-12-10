package com.sioux.smartparkingapp.controller;

import com.sioux.smartparkingapp.models.Appointment;
import com.sioux.smartparkingapp.models.ParkingSpot;
import com.sioux.smartparkingapp.services.AppointmentDetailsService;
import com.sioux.smartparkingapp.services.CommunicationService;
import com.sioux.smartparkingapp.services.ParkingSpotService;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import java.util.Optional;

@RestController
@RequestMapping("/communication")
@CrossOrigin("*")
public class CommunicationController {

    @Autowired
    private CommunicationService comService;

    @Autowired
    private AppointmentDetailsService appointmentDetailsServise;

    @Autowired
    private ParkingSpotService parkingSpotService;

    @PostMapping("/license")
    private ResponseEntity<?> SendSms(@RequestBody String licensePlate) throws MessagingException
    {
//        Boolean exists = Boolean.TRUE;
//        Boolean exists = appointmentDetailsServise.existsByLicence(licencePlate);

        Optional<Appointment> dbAppointment = appointmentDetailsServise.findByLicensePlate(licensePlate);

        Boolean emptySpot = parkingSpotService.checkForEmptySpot();

        if(dbAppointment.isPresent())
        {

            comService.SendEmail(dbAppointment.get(), emptySpot);

            if(!emptySpot)
            {
//                Message message = comService.SendSMS(dbAppointment.get().getVisitorPhone());

//                return new ResponseEntity<>(message, HttpStatus.OK);

                return new ResponseEntity<>("sms Sent", HttpStatus.OK);
            }
            else
            {
                System.out.println("The person can just parking inside");
                return new ResponseEntity<>("The person can just parking inside", HttpStatus.OK);
            }
        }
        else
        {
            System.out.println("License plate not in DB");
            return null;
        }
    }

    @PostMapping("/spotUpdate/{id}")
    public void receiveSpotUpdateID(@PathVariable(value = "id") Long id)
    {

    }

    @PostMapping("/spotUpdate")
    public void receiveSpotUpdateObject(@RequestBody ParkingSpot parkingSpot)
    {

    }
}
