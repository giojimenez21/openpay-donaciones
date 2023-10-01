package com.openpay.donation.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChargeRequest {
    private String method;
    private long amount;
    private String description;
    @JsonProperty("order_id")
    private String orderID;
    private Customer customer;
    private String confirm;
    @JsonProperty("send_email")
    private String sendEmail;
    @JsonProperty("redirect_url")
    private String redirectURL;
}

