package com.donation.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.donation.enums.DonationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DonationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donorId;
	private Long userId;
	private String donorName;

	@Enumerated(EnumType.STRING)
	private DonationType donationType;

	private double donationAmount;

	@CreationTimestamp
	private LocalDate donationDate;

}
