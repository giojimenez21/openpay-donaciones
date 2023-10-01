package com.openpay.donation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpay.donation.models.Charge;
import com.openpay.donation.models.Client;
import com.openpay.donation.services.ChargeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/charge")
@RequiredArgsConstructor
public class ChargeController {
    private final ChargeService chargeService;

    @PostMapping("/createCharge")
    public ResponseEntity<Charge> createCharge(@Valid @RequestBody Client client) {
        Charge charge = chargeService.createCharge(client);
        return ResponseEntity.ok().body(charge);
    }

}
