package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.SmsInfoRequestDto;
import com.pragma.powerup.application.handler.ISmsNotificationHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Send a message from the application to a specific client")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The request was answered successfully",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Only an employee can send notifications to clients",
                    content = @Content
            )
    })
    @PostMapping("/send")
    public ResponseEntity<Integer> sendSms(@RequestBody SmsInfoRequestDto smsInfoRequestDto){

         int securityCode = smsNotificationHandler.sendSms(smsInfoRequestDto);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(securityCode);
    }
}
