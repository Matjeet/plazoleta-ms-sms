package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.SmsInfoRequestDto;
import com.pragma.powerup.application.handler.ISmsNotificationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms/v1/")
@RequiredArgsConstructor
public class SmsRestController {

    private final ISmsNotificationHandler smsNotificationHandler;

    @PostMapping("/send")
    public ResponseEntity<Integer> sendSms(@RequestBody SmsInfoRequestDto smsInfoRequestDto){

         int securityCode = smsNotificationHandler.sendSms(smsInfoRequestDto);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(securityCode);
    }
}
