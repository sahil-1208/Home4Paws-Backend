package com.pets.model;

import com.pets.enums.PetBreed;
import com.pets.enums.PetColour;
import com.pets.enums.PetStatus;
import com.pets.enums.PetType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PetRequest {

    private String petName;
    private Double petWeight;
    private PetType petType;
    private Long userId;
    private PetBreed petBreed;
    private PetColour petColour;
    private PetStatus petStatus;
    private String petImage;

}
