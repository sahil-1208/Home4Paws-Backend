package com.pets.controller;

import com.pets.enums.Status;
import com.pets.model.PetRequest;
import com.pets.model.PetResponse;
import com.pets.service.PetService;
import com.pets.utility.PetConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetConvertor petConvertor;

    @PostMapping
    public PetResponse createNewPet(@RequestBody PetRequest petRequest, @RequestPart MultipartFile file) {
        return petService.createPet(petRequest, file);
    }

    @GetMapping("/{petId}")
    public PetResponse getPetByPetId(@PathVariable Long petId) {
        return petService.findPetByPetId(petId);
    }

    @PutMapping("/{petId}")
    public PetResponse updatePetById(@PathVariable Long petId, @RequestBody PetRequest petRequest) {
        return petService.updatePet(petId, petRequest);
    }

    @DeleteMapping("/{petId}")
    public Status deletePetById(@PathVariable Long petId) {
        return petService.deletePetById(petId);
    }

}
