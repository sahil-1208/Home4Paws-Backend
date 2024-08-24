package com.pets.globalException;

public class PetResponseException extends RuntimeException {

    public PetResponseException(String message) {
        super(message);
    }
}
