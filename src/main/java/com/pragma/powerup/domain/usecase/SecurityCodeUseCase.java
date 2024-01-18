package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.ISecurityCodeServicePort;

import java.util.Random;

public class SecurityCodeUseCase implements ISecurityCodeServicePort {

     private final Random rand = new Random();
    @Override
    public int generateCode() {

        int upperbound = 10;

        String securityCode = "";

        for (int i = 0; i <= 4; i++){
            securityCode += Integer.toString(rand.nextInt(upperbound));
        }

        return Integer.parseInt(securityCode);
    }
}
