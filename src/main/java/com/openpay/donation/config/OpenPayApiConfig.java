package com.openpay.donation.config;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


@Configuration
public class OpenPayApiConfig {
    @Value("${openpay.key.private}")
    private String openPayPrivate;

    @Bean
    public HttpHeaders authorizationHeaders() {
        String authHeader = openPayPrivate + ":";
        byte[] authHeaderBytes = authHeader.getBytes();
        String authHeaderValue = "Basic " + Base64.getEncoder().encodeToString(authHeaderBytes);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authHeaderValue);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
