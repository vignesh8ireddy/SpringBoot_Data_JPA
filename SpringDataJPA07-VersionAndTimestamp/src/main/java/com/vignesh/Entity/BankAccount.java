package com.vignesh.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="jpabankaccount")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccount {

	@Id
	@SequenceGenerator(name="sequenceBank", sequenceName="accNumber", initialValue=4000000, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequenceBank")
	private Long accountNumber;
	@NonNull
	private String accountHolderName;
	@NonNull
	private Long accountHolderMobile;
	@NonNull
	private Double accountBalance;
	@Version
	private Integer accountUpdateNumber;
	@CreationTimestamp
	private LocalDateTime accountCreationTime;
	@UpdateTimestamp
	private LocalDateTime accountLastUpdateTime;
	
}
