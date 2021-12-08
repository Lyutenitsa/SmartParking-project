package com.sioux.smartparkingapp.controller;

import com.sioux.smartparkingapp.models.Appointment;
import com.sioux.smartparkingapp.servises.AppointmentDetailsServise;
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
//private ManagerService managerservice

    @PostMapping("mail/{id}")
    public void sendSimpleMessage(@PathVariable (value="id") Long id) throws MessagingException {
        Boolean onGround=false;
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
        int i=2;
        long l=i;
        Appointment appointment =appointmentDetailsServise.findAppointmentById(id);
      //  LocalDate date = LocalDate.of(Integer.parseInt("2002"), Integer.parseInt("2"), Integer.parseInt("2"));
      //  LocalTime time = LocalTime.of(Integer.parseInt("2"), Integer.parseInt("2"), Integer.parseInt("2"));

     //   Appointment appointment = new Appointment(new Long(2) , date, time, 60, "Test", "Jelle Goossens", "2", "03490349");


        String title = appointment.getVisitorName()+" has arrived";
       String content="<html><h1>"+appointment.getVisitorName()+" has arrived at the local parking grounds</h1><br><h4>The visitor will be at the building soon.</h4></html>";

       if(!onGround) {
           content = "<html><h1>" + appointment.getVisitorName() + " has arrived at the of ground parking place</h1><br><h4>The visitor will be at the building in about 15 minutes.</h4></html>";
       }
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("smartparkingsioux@gmail.com");
        //Manager manager = managerService.getbyid(appointment.getId())
        //helper.setFrom(manager.getEmail());

        helper.setTo("432258@student.fontys.nl");
        helper.setSubject(title);
        helper.setText(content,true);

        mailSender.send(message);


    }


    @PostMapping()
    private void sendmail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("smartparkingsioux@gmail.com", "5T270W@j2&%d");
            }
        });
        Message msg = new MimeMessage(session);

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("432258@student.fontys.nl"));
        msg.setFrom(new InternetAddress("tutorialspoint@gmail.com", false));

        Appointment appointment = appointmentDetailsServise.findAppointmentById(1L);
        //Manager manager = managerService.getbyid(appointment.getId())
        //      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(manager.getEmail()));

        String title = appointment.getVisitorName()+" has arrived";
        msg.setSubject(title);
        String content="<h1>A visitor has arrived at the parking grounds</h1><br><br><h4>"+appointment.getVisitorName()+" has arrived at the</h4>";
        msg.setContent(content, "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(content, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        //MimeBodyPart attachPart = new MimeBodyPart();

        //  attachPart.attachFile("/var/tmp/image19.png");
        // multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }
}
