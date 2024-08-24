package com.donation.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donation.entity.DonationEntity;
import com.donation.enums.Status;
import com.donation.models.DonationRequest;
import com.donation.models.DonationResponse;
import com.donation.repository.DonationRepository;
import com.donation.utils.Convertor;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private Convertor convertor;

    public DonationResponse createOrder(DonationRequest donationRequest) {
        DonationResponse donationResponse = null;
        if (Objects.nonNull(donationRequest)) {
            DonationEntity donationEntity = convertor.requestToEntity(donationRequest);
            donationEntity = donationRepository.save(donationEntity);
            donationResponse = convertor.entityToResponse(donationEntity);
        }
        return donationResponse;
    }

    public DonationResponse findByDonorId(Long donorId) {
        Optional<DonationEntity> donationEntityOptional = donationRepository.findByDonorId(donorId);
        if (donationEntityOptional.isPresent()) {
            DonationEntity donationEntity = donationEntityOptional.get();
            return convertor.entityToResponse(donationEntity);
        }
        return null;
    }

    public DonationResponse update(Long donorId, DonationRequest donationRequest) {
        DonationResponse donationResponse = null;
        Optional<DonationEntity> optionalEntity = donationRepository.findById(donorId);
        if (optionalEntity.isPresent()) {
            DonationEntity donationEntity = optionalEntity.get();
            donationEntity = convertor.updateEntity(donationRequest, donationEntity);
            donationEntity = donationRepository.save(donationEntity);
            donationResponse = convertor.entityToResponse(donationEntity);
        }
        return donationResponse;

    }

    public Status deleteOrder(Long donorId) {
        Optional<DonationEntity> optionalEntity = donationRepository.findById(donorId);
        if (Objects.nonNull(optionalEntity)) {
            donationRepository.deleteById(donorId);
            return Status.SUCCESS;
        }
        return Status.FAILED;
    }

}
