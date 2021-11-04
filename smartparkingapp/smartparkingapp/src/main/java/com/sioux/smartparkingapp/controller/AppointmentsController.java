package com.sioux.smartparkingapp.controller;

import com.sioux.smartparkingapp.models.Appointment;
import com.sioux.smartparkingapp.servises.AppointmentDetailsServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/appointments")

public class AppointmentsController {


    @Autowired
    private AppointmentDetailsServise appointmentDetailsServise;

    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentDetailsServise.saveAppointment(appointment);
    }
    @GetMapping()
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> allAppointments = appointmentDetailsServise.getAppointments();

        if(!allAppointments.isEmpty()) {
            return ResponseEntity.ok().body(allAppointments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Appointment> findAppointmentById(@PathVariable (value="id") Long id){
        Appointment appointment =appointmentDetailsServise.findAppointmentById(id);

        if(appointment != null) {
            return ResponseEntity.ok().body(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @PutMapping("/update")
    public Appointment updateAppointment(@RequestBody Appointment appointment){
        return appointmentDetailsServise.updateAppointment(appointment);
    }


    @DeleteMapping("/deleteAppointment/{id}")
    public String deleteNewsItem(@PathVariable Long id){

        return appointmentDetailsServise.deleteAppointment(id);

    }

    @DeleteMapping("/appointments")
    public String deleteAll(){
        return appointmentDetailsServise.deleteAll();

    }


}
