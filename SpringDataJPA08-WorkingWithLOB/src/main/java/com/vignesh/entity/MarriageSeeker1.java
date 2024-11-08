package com.vignesh.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class MarriageSeeker1 {

	//@Column(length=20)
	@NonNull
	private String address;
	
	@NonNull
	private LocalDateTime dob;
	
	//@Column(length=20)
	@NonNull
	private String gender;
	
	@NonNull
	@Lob
	private byte[] image;
	
	//@Column(length=20)
	@NonNull
	private String name;
	
	@NonNull
	@Lob
	private char[] resume;
	
	@Id
	@SequenceGenerator(name="generator", sequenceName="idGen", initialValue=5000000, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	

	
}
