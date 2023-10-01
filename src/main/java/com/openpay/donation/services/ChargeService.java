package com.openpay.donation.services;

import com.openpay.donation.models.Charge;
import com.openpay.donation.models.Client;


public interface ChargeService {
    public Charge createCharge(Client client);
}
