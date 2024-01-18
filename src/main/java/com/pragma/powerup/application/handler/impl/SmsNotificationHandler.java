package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.SmsInfoRequestDto;
import com.pragma.powerup.application.handler.ISmsNotificationHandler;
import com.pragma.powerup.domain.api.ISecurityCodeServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsNotificationHandler implements ISmsNotificationHandler {

    private final ISecurityCodeServicePort securityCodeServicePort;
    @Override
    public int sendSms(SmsInfoRequestDto smsInfoRequestDto) {

        StringBuilder message = new StringBuilder();

        int securityCode = securityCodeServicePort.generateCode();

        message.append(String.format("Hola, %s! Tu pedido de %s ya está listo, puedes reclamarlo con el código: %s",
                smsInfoRequestDto.getName(),
                smsInfoRequestDto.getRestaurantName(),
                securityCode
        ));
        
        return securityCode;
    }
}
