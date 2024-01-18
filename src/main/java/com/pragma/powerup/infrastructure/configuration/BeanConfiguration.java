package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IObjectServicePort;
import com.pragma.powerup.domain.usecase.ObjectUseCase;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IObjectEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    @Bean
    public IObjectServicePort objectServicePort() {
        return new ObjectUseCase();
    }
}