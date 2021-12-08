package com.sioux.smartparkingapp.servises;

import com.sioux.smartparkingapp.Repo.ParkingSpotRepository;
import com.sioux.smartparkingapp.models.ParkingSpot;
import com.sioux.smartparkingapp.models.SMS;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommunicationService{


//    private static final RestTemplate restTemplate = new RestTemplate();

//    @Autowired
//    private ParkingSpotService parkingSpotService;

    public Message SendSMS(String phone){

        Message message = SMS.SendSMS(phone);

        return (message);
    }

    public String SendEmail(String email){
        //send email
        return ("Email sent...");
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
