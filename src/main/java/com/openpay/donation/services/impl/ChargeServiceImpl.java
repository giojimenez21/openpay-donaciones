package com.openpay.donation.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.openpay.donation.models.Charge;
import com.openpay.donation.models.ChargeRequest;
import com.openpay.donation.models.Client;
import com.openpay.donation.models.Customer;
import com.openpay.donation.services.ChargeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChargeServiceImpl implements ChargeService {
    @Value("${openpay.redirect}")
    private String urlRedirect;
    @Value("${openpay.url}")
    private String urlOpenPay;
    @Value("${openpay.key.id}")
    private String openPayId;
    private final HttpHeaders requestHeadersOP;
    private final RestTemplate restTemplate;

    @Override
    public Charge createCharge(Client client) {
        Customer customer = Customer.builder()
            .name(client.getName())
            .lastName(client.getLastName())
            .phoneNumber(client.getPhoneNumber())
            .email(client.getEmail())
            .build();

        ChargeRequest chargeRequest = ChargeRequest.builder()
            .method("card")
            .amount(client.getAmount())
            .description("Donacion")
            .orderID(UUID.randomUUID().toString())
            .customer(customer)
            .confirm("false")
            .sendEmail("false")
            .redirectURL(urlRedirect)
            .build();

        HttpEntity<ChargeRequest> httpEntity = new HttpEntity<>(chargeRequest, requestHeadersOP);

        ResponseEntity<Charge> response = restTemplate.exchange(
            urlOpenPay + openPayId + "/charges",
            HttpMethod.POST,
            httpEntity,
            Charge.class
        );

        return response.getBody();
    }

}
