package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.SmsInfoRequestDto;
import com.pragma.powerup.domain.api.ISecurityCodeServicePort;
import com.pragma.powerup.domain.api.ISenderServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SmsNotificationHandlerTest {

    private SmsInfoRequestDto smsInfoRequestDto;
    @Mock
    private ISecurityCodeServicePort securityCodeServicePort;
    @Mock
    private ISenderServicePort senderServicePort;

    @InjectMocks
    private SmsNotificationHandler smsNotificationHandler;

    @BeforeEach
    void setUp() {
        smsInfoRequestDto = new SmsInfoRequestDto();
    }

    @Test
    void sendSms() {

        smsInfoRequestDto.setRestaurantName("");
        smsInfoRequestDto.setName("");
        smsInfoRequestDto.setPhoneNumber("");

        when(securityCodeServicePort.generateCode()).thenReturn(1);
        doNothing().when(senderServicePort).send(anyString(),anyString());

        int result = smsNotificationHandler.sendSms(smsInfoRequestDto);

        verify(securityCodeServicePort, times(1)).generateCode();
        verify(senderServicePort, times(1)).send(anyString(), anyString());
        assertInstanceOf(Integer.class, result);
    }
}