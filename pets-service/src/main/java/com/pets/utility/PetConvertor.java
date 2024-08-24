package com.pets.utility;

import com.pets.entity.PetEntity;
import com.pets.model.PetRequest;
import com.pets.model.PetResponse;
import org.springframework.stereotype.Component;

@Component
public class PetConvertor {

    public PetEntity requestToEntity(PetRequest petRequest) {
        PetEntity petEntity = new PetEntity();
        petEntity.setPetName(petRequest.getPetName());
        petEntity.setPetWeight(petRequest.getPetWeight());
        petEntity.setPetType(petRequest.getPetType());
        petEntity.setPetBreed(petRequest.getPetBreed());
        petEntity.setPetColour(petRequest.getPetColour());
        petEntity.setPetStatus(petRequest.getPetStatus());
        petEntity.setUserId(petRequest.getUserId());
        petEntity.setPetImage(petRequest.getPetImage());
        return petEntity;
    }

    public PetResponse entityToResponse(PetEntity petEntity) {
        PetResponse petResponse = new PetResponse();
        petResponse.setPetId(petEntity.getPetId());
        petResponse.setPetName(petEntity.getPetName());
        petResponse.setPetWeight(petEntity.getPetWeight());
        petResponse.setUserId(petEntity.getUserId());
        petResponse.setPetType(petEntity.getPetType());
        petResponse.setPetBreed(petEntity.getPetBreed());
        petResponse.setPetColour(petEntity.getPetColour());
        petResponse.setPetStatus(petEntity.getPetStatus());
        petResponse.setPetImage(petEntity.getPetImage());
        return petResponse;
    }

    public PetEntity updateEntity(PetRequest petRequest, PetEntity petEntity) {
        petEntity.setPetName(petRequest.getPetName());
        petEntity.setPetWeight(petRequest.getPetWeight());
        petEntity.setPetType(petRequest.getPetType());
        petEntity.setPetBreed(petRequest.getPetBreed());
        petEntity.setPetColour(petRequest.getPetColour());
        petEntity.setPetStatus(petRequest.getPetStatus());
        petEntity.setUserId(petRequest.getUserId());
        petEntity.setPetImage(petRequest.getPetImage());
        return petEntity;
    }
}
