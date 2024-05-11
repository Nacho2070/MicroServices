package com.app.orders_service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * WebClientConfig
 */
@Configuration
public class WebClientConfig {
    @Bean
    public WebClient.Builder WebClient(){
      return WebClient.builder();
    }
}