package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.SmsInfoRequestDto;

public interface ISmsNotificationHandler {

    int sendSms(SmsInfoRequestDto smsInfoRequestDto);
}
