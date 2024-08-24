package com.donation.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.donation.entity.DonationEntity;
import com.donation.models.DonationRequest;
import com.donation.models.DonationResponse;

@Component
public class Convertor {

    public DonationEntity requestToEntity(DonationRequest donationRequest) {
        DonationEntity donationEntity = new DonationEntity();
        BeanUtils.copyProperties(donationRequest, donationEntity);
        return donationEntity;
    }

    public DonationResponse entityToResponse(DonationEntity donationEntity) {
        DonationResponse donationResponse = new DonationResponse();
        BeanUtils.copyProperties(donationEntity, donationResponse);
        return donationResponse;
    }

    public DonationEntity updateEntity(DonationRequest donationRequest, DonationEntity donationEntity) {
        BeanUtils.copyProperties(donationRequest, donationEntity);
        return donationEntity;
    }

}
