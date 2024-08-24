package com.donation.service;

import com.donation.enums.Status;
import com.donation.exceptionHandler.DonationResponseException;
import com.donation.models.DonationRequest;
import com.donation.models.DonationResponse;
import org.springframework.stereotype.Service;

@Service
public interface DonationService {
    DonationResponse createOrder(DonationRequest donationRequest) throws DonationResponseException;

    DonationResponse findByDonorId(Long id) throws DonationResponseException;

    DonationResponse update(Long id, DonationRequest donationRequest) throws DonationResponseException;

    Status deleteOrder(Long id);
}
