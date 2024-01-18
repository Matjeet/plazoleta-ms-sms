package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.ISenderServicePort;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;


public class SenderUseCase implements ISenderServicePort {

    private final TwilioRestClient client;

    public SenderUseCase(TwilioRestClient client){
        this.client = client;
    }

    @Override
    public void send(String to, String message) {

        new MessageCreator(
                new PhoneNumber(to),
                new PhoneNumber("+12456"),
                message
        ).create(client);
    }
}
