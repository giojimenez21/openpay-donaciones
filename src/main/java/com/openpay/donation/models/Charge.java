package com.openpay.donation.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Charge {
    private String id;
    private Object authorization;
    @JsonProperty("operation_type")
    private String operationType;
    @JsonProperty("transaction_type")
    private String transactionType;
    private String status;
    private boolean conciliated;
    @JsonProperty("creation_date")
    private String creationDate;
    @JsonProperty("operation_date")
    private String operationDate;
    private String description;
    @JsonProperty("error_message")
    private Object errorMessage;
    private String orderID;
    private double amount;
    private Customer customer;
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
    private String currency;
    private String method;

}
