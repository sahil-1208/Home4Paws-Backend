package com.pets.entity;


import com.pets.enums.PetBreed;
import com.pets.enums.PetColour;
import com.pets.enums.PetStatus;
import com.pets.enums.PetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;
    private String petName;
    private Double petWeight;
    private Long userId;

    @Lob
    private String petImage;

    @Enumerated(value = EnumType.STRING)
    private PetType petType;

    @Enumerated(value = EnumType.STRING)
    private PetBreed petBreed;

    @Enumerated(value = EnumType.STRING)
    private PetColour petColour;

    @Enumerated(value = EnumType.STRING)
    private PetStatus petStatus;

}
