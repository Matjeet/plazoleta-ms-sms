package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IObjectServicePort;
import com.pragma.powerup.domain.api.ISecurityCodeServicePort;
import com.pragma.powerup.domain.api.ISenderServicePort;
import com.pragma.powerup.domain.usecase.ObjectUseCase;
import com.pragma.powerup.domain.usecase.SecurityCodeUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.SenderNotificationAdapter;
import com.twilio.http.TwilioRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Value("${twilio.username}")
    private String username;
    @Value("${twilio.password}")
    private String password;

    @Bean
    public TwilioRestClient twilioRestClient(){
        return new TwilioRestClient.Builder(username,password).build();
    }

    @Bean
    public ISenderServicePort senderServicePort(TwilioRestClient twilioRestClient){
        return new SenderNotificationAdapter(twilioRestClient);
    }
    @Bean
    public ISecurityCodeServicePort securityCodeServicePort(){
        return new SecurityCodeUseCase();
    }

    @Bean
    public IObjectServicePort objectServicePort() {
        return new ObjectUseCase();
    }
}