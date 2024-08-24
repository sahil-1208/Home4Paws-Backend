package com.pets.service;

import com.pets.entity.PetEntity;
import com.pets.enums.Status;
import com.pets.globalException.PetResponseException;
import com.pets.model.PetRequest;
import com.pets.model.PetResponse;
import com.pets.repository.PetRepository;
import com.pets.utility.PetConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetConvertor petConvertor;

    private static final String IMAGE_PATH = "D:/Paw Pledge/image";


    public PetResponse createPet(PetRequest petRequest, MultipartFile file) {
        PetResponse petResponse = null;
        if (Objects.nonNull(petRequest)) {
            try {
                PetEntity petEntity = petConvertor.requestToEntity(petRequest);

                if (file != null) {
                    String imageFileName = file.getOriginalFilename();
                    String imagePath = IMAGE_PATH + imageFileName;
                    File destFile = new File(imagePath);
                    file.transferTo(destFile);
                    petEntity.setPetImage(imagePath);
                }

                petEntity = petRepository.save(petEntity);
                petResponse = petConvertor.entityToResponse(petEntity);
            } catch (IOException ex) {
                throw new PetResponseException("Error in saving the image: " + ex.getMessage());
            }
        }
        return petResponse;
    }


    public PetResponse findPetByPetId(Long petId) {
        Optional<PetEntity> petEntityOptional = petRepository.findPetByPetId(petId);
        if (petEntityOptional.isPresent()) {
            PetEntity petEntity = petEntityOptional.get();
            return petConvertor.entityToResponse(petEntity);
        } else {
            throw new PetResponseException("Pet not Found :" + petId);
        }
    }

    public PetResponse updatePet(Long petId, PetRequest petRequest) {
        return petRepository.findById(petId).map(petEntity -> {
            PetEntity updatePetEntity = petConvertor.updateEntity(petRequest, petEntity);
            PetEntity savedPetEntity = petRepository.save(updatePetEntity);
            return petConvertor.entityToResponse(savedPetEntity);
        }).orElseThrow(() -> new PetResponseException("pet with id " + petId + " details not updated "));
    }

    public Status deletePetById(Long petId) {
        Optional<PetEntity> optionalPetEntity = petRepository.findById(petId);
        if (optionalPetEntity.isPresent()) {
            petRepository.deleteById(petId);
            return Status.SUCCESS;
        }
        return Status.FAILED;
    }
}