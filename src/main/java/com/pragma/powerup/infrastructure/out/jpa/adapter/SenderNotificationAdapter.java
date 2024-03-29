package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.api.ISenderServicePort;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SenderNotificationAdapter implements ISenderServicePort {

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;
    @Value("${twilio.accountId}")
    private String accountId;
    @Value("${twilio.authToken}")
    private String authToken;

    private final TwilioRestClient client;

    public SenderNotificationAdapter(){
        client = new TwilioRestClient.Builder(accountId,authToken).build();
    }

    @Override
    public void send(String to, String message) {

        new MessageCreator(
                new PhoneNumber(to),
                new PhoneNumber(twilioPhoneNumber),
                message
        ).create(client);
    }
}
