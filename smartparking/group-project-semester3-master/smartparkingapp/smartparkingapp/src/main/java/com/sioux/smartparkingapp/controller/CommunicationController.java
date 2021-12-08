package com.sioux.smartparkingapp.controller;

import com.sioux.smartparkingapp.Repo.AppointmentRepository;
import com.sioux.smartparkingapp.Repo.UserRepository;
import com.sioux.smartparkingapp.models.Appointment;
import com.sioux.smartparkingapp.servises.AppointmentDetailsServise;
import com.sioux.smartparkingapp.servises.CommunicationService;
import com.sioux.smartparkingapp.servises.ParkingSpotService;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/communication")
public class CommunicationController {

    @Autowired
    private CommunicationService comService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentDetailsServise appointmentDetailsServise;

    @Autowired
    private ParkingSpotService parkingSpotService;

    @PostMapping("/sms")
    private ResponseEntity<?> SendSms(@RequestBody String licensePlate)
    {
//        Boolean exists = Boolean.TRUE;

//        Boolean exists = appointmentDetailsServise.existsByLicence(licencePlate);

        Optional<Appointment> dbAppointment = appointmentDetailsServise.findByLicensePlate(licensePlate);

        Boolean emptySpot = parkingSpotService.checkForEmptySpot();

        if(dbAppointment.isPresent()){

            //Optional<Manager> manager = managerService.findByID

            if(!emptySpot)
            {
                Message message = comService.SendSMS(dbAppointment.get().getVisitorPhone());

                // email


                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            else
            {

                //email
                System.out.println("The person can just parking incide");
                return new ResponseEntity<>("The person can just parking incide", HttpStatus.OK);
            }
        }
        else{
            System.out.println("License plate not in DB");
            return null;
        }
    }

    @PostMapping("/email")
    private void SendEmail(@RequestBody String data)
    {
        data = "123";// appointmentDetailsServise.existsByLicence(licencePlate);

        if(data.equals(123))
            comService.SendEmail("email@email.com");

        else
            System.out.println("false");
    }
}
