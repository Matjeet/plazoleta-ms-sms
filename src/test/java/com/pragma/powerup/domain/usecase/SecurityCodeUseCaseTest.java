package com.pragma.powerup.domain.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


class SecurityCodeUseCaseTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void generateCode() {

        SecurityCodeUseCase securityCodeUseCase = new SecurityCodeUseCase();

        int result = securityCodeUseCase.generateCode();

        assertInstanceOf(Integer.class, result);

    }
}