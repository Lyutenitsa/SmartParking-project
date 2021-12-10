package com.sioux.smartparkingapp.services;


import com.sioux.smartparkingapp.Repo.AppointmentRepository;
import com.sioux.smartparkingapp.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AppointmentDetailsService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentDetailsService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public Appointment saveAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }
    public List<Appointment> getAppointments(){
        return appointmentRepository.findAll();
    }
    public Appointment findAppointmentById(Long id){
        return appointmentRepository.findById(id).orElse(null);
    }
    public String deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
        return "Appointment removed";
    }
    public String deleteAll(){
        appointmentRepository.deleteAll();

        return "appointment removed";
    }
    public String updateAppointment(Appointment appointment){
        appointmentRepository.save(appointment);
        return "appointment updated successfully";
    }
    public Optional<Appointment> findByLicensePlate(String licencePlate){
        return appointmentRepository.findByLicensePlate(licencePlate);
    }
}
