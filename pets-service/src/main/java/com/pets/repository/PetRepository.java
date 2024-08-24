package com.pets.repository;

import com.pets.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetEntity,Long> {

    Optional<PetEntity> findPetByPetId(Long petId);
}
