package com.sioux.smartparkingapp.controller;

import com.sioux.smartparkingapp.models.Appointment;
import com.sioux.smartparkingapp.models.Manager;
import com.sioux.smartparkingapp.servises.AppointmentDetailsServise;
import com.sioux.smartparkingapp.servises.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Properties;

@RestController
@RequestMapping("/email")
@CrossOrigin("*")
public class MailController {

    @Autowired
    private AppointmentDetailsServise appointmentDetailsServise;
    private ManagerService managerService;


    public void sendSimpleMessage(Appointment appointment, Boolean onGround) throws MessagingException {
        //Boolean onGround=false;
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("smartparkingsioux@gmail.com");
        mailSender.setPassword("5T270W@j2&%d");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

      //  Appointment appointment = appointmentDetailsServise.findAppointmentById(id);

        String title = appointment.getVisitorName()+" has arrived";
        String content="<html><h1>"+appointment.getVisitorName()+" has arrived at the local parking grounds</h1><br><h4>The visitor will be at the building soon.</h4></html>";

       if(!onGround) {
           content = "<html><h1>" + appointment.getVisitorName() + " has arrived at the of ground parking place</h1><br><h4>The visitor will be at the building in about 15 minutes.</h4></html>";
       }
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        //helper.setFrom("smartparkingsioux@gmail.com");
        Manager manager = managerService.findById(appointment.getAppointment_id());
        helper.setFrom(manager.getEmail());

        helper.setTo("432258@student.fontys.nl");
        helper.setSubject(title);
        helper.setText(content,true);

        mailSender.send(message);
    }



}
