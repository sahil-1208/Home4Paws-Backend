package com.donation.utils;

import org.springframework.stereotype.Component;

import com.donation.entity.DonationEntity;
import com.donation.models.DonationRequest;
import com.donation.models.DonationResponse;

@Component
public class Convertor {

    public DonationEntity requestToEntity(DonationRequest donationRequest) {
        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setDonorName(donationRequest.getDonorName());
        donationEntity.setDonationAmount(donationRequest.getDonationAmount());
        donationEntity.setUserId(donationRequest.getUserId());
        donationEntity.setDonationDate(donationRequest.getDonationDate());
        donationEntity.setDonationType(donationRequest.getDonationType());
        return donationEntity;
    }

    public DonationResponse entityToResponse(DonationEntity donationEntity) {
        DonationResponse donationResponse = new DonationResponse();
        donationResponse.setDonorId(donationEntity.getDonorId());
        donationResponse.setDonorName(donationEntity.getDonorName());
        donationResponse.setDonationAmount(donationEntity.getDonationAmount());
        donationResponse.setUserId(donationEntity.getUserId());
        donationResponse.setDonationDate(donationEntity.getDonationDate());
        donationResponse.setDonationType(donationEntity.getDonationType());
        return donationResponse;
    }

    public DonationEntity updateEntity(DonationRequest donationRequest, DonationEntity donationEntity) {
        donationEntity.setDonationAmount(donationRequest.getDonationAmount());
        donationEntity.setDonationDate(donationRequest.getDonationDate());
        donationEntity.setUserId(donationRequest.getUserId());
        donationEntity.setDonationType(donationRequest.getDonationType());
        donationEntity.setDonorName(donationRequest.getDonorName());
        return donationEntity;
    }

}
