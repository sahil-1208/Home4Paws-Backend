package com.donation.controller;

import com.donation.exceptionHandler.DonationResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.donation.enums.Status;
import com.donation.models.DonationRequest;
import com.donation.models.DonationResponse;
import com.donation.service.DonationService;

@RestController
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public ResponseEntity<DonationResponse> create(@RequestBody DonationRequest donationRequest) {
        try {
            return ResponseEntity.ok().body(donationService.createOrder(donationRequest));
        } catch (DonationResponseException e) {
            throw new DonationResponseException(e.getMessage());
        }
    }

    @GetMapping("/{donorId}")
    public ResponseEntity<DonationResponse> getByDonationRequest(@PathVariable Long donorId) {
        try {
            return ResponseEntity.ok().body(donationService.findByDonorId(donorId));
        } catch (DonationResponseException e) {
            throw new DonationResponseException(e.getMessage());
        }
    }

    @PutMapping("/{donorId}")
    public ResponseEntity<DonationResponse> updateByDonorId(@PathVariable Long donorId, @RequestBody DonationRequest donationRequest) {
        try {
            return ResponseEntity.ok().body(donationService.update(donorId, donationRequest));
        } catch (DonationResponseException e) {
            throw new DonationResponseException(e.getMessage());
        }
    }

    @DeleteMapping("/{donorId}")
    public ResponseEntity<Status> deleteByDonorId(@PathVariable Long donorId) {
        try {
            return ResponseEntity.ok().body(donationService.deleteOrder(donorId));
        } catch (DonationResponseException e) {
            throw new DonationResponseException(e.getMessage());
        }
    }
}
