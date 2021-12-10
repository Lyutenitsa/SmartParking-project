package com.sioux.smartparkingapp.models;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public abstract class SMS {

    private static final String ACCOUNT_SID = "AC10c92df1b4264963e47ded1d09fc4881";
    private static final String AUTH_TOKEN = "09ad8cdfe0f1dfa7ebf8aaaf03375b0c";
    private static final String PhoneNumber = "+12526187218";

    public static Message SendSMS(String receiver)
    {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(receiver), // to
                new PhoneNumber(PhoneNumber), // from
                "There are no empty parking spots. Please make your way to the outside parking area. Thank you.").create();

        System.out.println(message.getSid());
        return (message);
    }

}
