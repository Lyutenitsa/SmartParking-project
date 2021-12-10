package com.sioux.smartparkingapp.services;

import com.sioux.smartparkingapp.models.Appointment;
import com.sioux.smartparkingapp.models.SMS;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class CommunicationService{


//    private static final RestTemplate restTemplate = new RestTemplate();

//    @Autowired
//    private ParkingSpotService parkingSpotService;

    public Message SendSMS(String phone){

        Message message = SMS.SendSMS(phone);

        return (message);
    }

    public void SendEmail(Appointment appointment, Boolean onGround) throws MessagingException
    {
//        Boolean onGround=false;
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
//        Appointment appointment = appointmentDetailsServise.findAppointmentById(id);

        String title = appointment.getVisitorName()+" has arrived";
        String content="<html><h1>"+appointment.getVisitorName()+" has arrived at the local parking grounds</h1><br><h4>The visitor will be at the building soon.</h4></html>";

        if(!onGround) {
            content = "<html><h1>" + appointment.getVisitorName() + " has arrived at the off-ground parking place</h1><br><h4>The visitor will be at the building in about 15 minutes.</h4></html>";
        }
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("smartparkingsioux@gmail.com");
//        Manager manager = managerService.findById(appointment.getManager().getId());

        helper.setTo(appointment.getManager().getEmail());
        helper.setSubject(title);
        helper.setText(content,true);

        mailSender.send(message);
    }



//    public static String SendUpdate(){
//
//
//        String url = "http://localhost:8080/api/item/HelloWorld";
//
//        String response = restTemplate.getForObject(url, String.class);
//        System.out.println(response);
//        return response;
//    }
}
