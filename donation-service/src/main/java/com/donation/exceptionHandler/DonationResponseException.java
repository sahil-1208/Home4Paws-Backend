package com.donation.exceptionHandler;

public class DonationResponseException extends RuntimeException {

    public DonationResponseException(String message) {
        super(message);
    }
}
