package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Concerts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int concertId;
	private int venueId;
	private String concertType;
	private int seats;
}
