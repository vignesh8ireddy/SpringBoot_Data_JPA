package com.vignesh.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name="JPACustomerDateTime")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
	
	@Id
	@SequenceGenerator(name="sequence", sequenceName="cidGen", initialValue=100, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence")
	private Integer cid;
	@NonNull
	private String cname;
	@NonNull
	private String caddress;
	@NonNull
	private Double billamt;
	@NonNull
	private LocalDateTime dateOfBirth;
	@NonNull
	private LocalDate dateOfPurchase;
	@NonNull
	private LocalTime timeOfPurchase;	
	
}
