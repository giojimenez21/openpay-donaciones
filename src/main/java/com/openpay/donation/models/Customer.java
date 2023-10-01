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
public class Customer {
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private Object address;
    @JsonProperty("creation_date")
    private String creationDate;
    @JsonProperty("external_id")
    private Object externalID;
    private Object clabe;
}
