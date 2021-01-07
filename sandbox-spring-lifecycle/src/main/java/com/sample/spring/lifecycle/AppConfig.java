package com.sample.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public LifecycleTestService transferService() {
        return new LifecycleTestService();
    }
    
}