package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.SmsInfoRequestDto;
import com.pragma.powerup.application.handler.ISmsNotificationHandler;
import com.pragma.powerup.domain.api.ISecurityCodeServicePort;
import com.pragma.powerup.domain.api.ISenderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsNotificationHandler implements ISmsNotificationHandler {

    private final ISecurityCodeServicePort securityCodeServicePort;
    private final ISenderServicePort senderServicePort;
    @Override
    public int sendSms(SmsInfoRequestDto smsInfoRequestDto) {

        StringBuilder message = new StringBuilder();

        int securityCode = securityCodeServicePort.generateCode();

        message.append(String.format("Hola, %s! Tu pedido de %s ya está listo, puedes reclamarlo con el código: %s",
                smsInfoRequestDto.getName(),
                smsInfoRequestDto.getRestaurantName(),
                securityCode
        ));

        senderServicePort.send(smsInfoRequestDto.getPhoneNumber(),message.toString());

        return securityCode;
    }
}
