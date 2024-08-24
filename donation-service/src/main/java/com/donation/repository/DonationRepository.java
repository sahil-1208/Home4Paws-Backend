package com.donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donation.entity.DonationEntity;

public interface DonationRepository extends JpaRepository<DonationEntity,Long>{

}
