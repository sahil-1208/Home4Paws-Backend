package com.donation.service;

import java.util.Objects;
import java.util.Optional;

import com.donation.exceptionHandler.DonationResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donation.entity.DonationEntity;
import com.donation.enums.Status;
import com.donation.models.DonationRequest;
import com.donation.models.DonationResponse;
import com.donation.repository.DonationRepository;
import com.donation.utils.Convertor;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private Convertor convertor;

    @Override
    public DonationResponse createOrder(DonationRequest donationRequest) throws DonationResponseException {
        DonationResponse donationResponse = null;
        if (Objects.nonNull(donationRequest)) {
            DonationEntity donationEntity = convertor.requestToEntity(donationRequest);
            donationEntity = donationRepository.save(donationEntity);
            donationResponse = convertor.entityToResponse(donationEntity);
            return donationResponse;
        }
        else throw new DonationResponseException("Please Try Again");
    }

    @Override
    public DonationResponse findByDonorId(Long id) throws DonationResponseException {
        Optional<DonationEntity> donationEntityOptional = donationRepository.findById(id);
        if (donationEntityOptional.isPresent()) {
            DonationEntity donationEntity = donationEntityOptional.get();
            return convertor.entityToResponse(donationEntity);
        }
        else throw new DonationResponseException("Not Donation Found for Id : " + id);
    }

    @Override
    public DonationResponse update(Long id, DonationRequest donationRequest) throws DonationResponseException {
        DonationResponse donationResponse = null;
        Optional<DonationEntity> optionalEntity = donationRepository.findById(id);
        if (optionalEntity.isPresent()) {
            DonationEntity donationEntity = optionalEntity.get();
            donationEntity = convertor.updateEntity(donationRequest, donationEntity);
            donationEntity = donationRepository.save(donationEntity);
            donationResponse = convertor.entityToResponse(donationEntity);
            return donationResponse;
        }
        else throw new DonationResponseException("Not Donation Found for Id : " + id);

    }

    @Override
    public Status deleteOrder(Long id) {
        Optional<DonationEntity> optionalEntity = donationRepository.findById(id);
        if (Objects.nonNull(optionalEntity)) {
            donationRepository.deleteById(id);
            return Status.SUCCESS;
        }
        return Status.FAILED;
    }

}
