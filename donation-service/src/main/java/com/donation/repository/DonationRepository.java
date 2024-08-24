package com.donation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donation.entity.DonationEntity;

public interface DonationRepository extends JpaRepository<DonationEntity,Long>{

	Optional<DonationEntity> findByDonorId(Long donorId);

}
