package com.donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public DonationResponse create(@RequestBody DonationRequest donationRequest) {
        return donationService.createOrder(donationRequest);
    }

    @GetMapping("/{donorId}")
    public DonationResponse getByDonationRequest(@PathVariable Long donorId) {
        return donationService.findByDonorId(donorId);
    }

    @PutMapping("/{donorId}")
    public DonationResponse updateByDonorId(@PathVariable Long donorId, @RequestBody DonationRequest donationRequest) {
        return donationService.update(donorId, donationRequest);
    }

    @DeleteMapping("/{id}")
    public Status deleteByDonorId(@PathVariable Long donorId) {
        return donationService.deleteOrder(donorId);
    }
}


