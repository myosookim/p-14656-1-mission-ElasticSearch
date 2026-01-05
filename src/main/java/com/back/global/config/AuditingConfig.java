package com.back.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;

import java.time.OffsetDateTime;
import java.util.Optional;

@Configuration
public class AuditingConfig {
    @Bean
    public DateTimeProvider dateTimeProvider() {
        // save() / update() 할 때 Spring이 알아서 시간을 넣음
        // 현재 시간을 넣어준다
        return () -> Optional.of(OffsetDateTime.now());
    }
}
