package com.pets.model;

import com.pets.enums.PetBreed;
import com.pets.enums.PetColour;
import com.pets.enums.PetStatus;
import com.pets.enums.PetType;
import lombok.Data;

@Data
public class PetResponse {

    private Long petId;
    private String petName;
    private Double petWeight;
    private Long userId;
    private PetType petType;
    private PetBreed petBreed;
    private PetColour petColour;
    private PetStatus petStatus;
    private String petImage;

}
