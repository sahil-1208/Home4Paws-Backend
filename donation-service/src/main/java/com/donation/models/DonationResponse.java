package com.donation.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DonationResponse {

    private Long donorId;
    private String donorName;
    private double donationAmount;
    private LocalDate donationDate;

}
