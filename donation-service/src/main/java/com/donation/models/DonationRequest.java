package com.donation.models;

import java.time.LocalDate;

import com.donation.enums.DonationType;

import lombok.Data;

@Data
public class DonationRequest {

    private Long userId;
    private String donorName;
    private DonationType donationType;
    private double donationAmount;
    private LocalDate donationDate;


}
