package com.vignesh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String cname;
	private String caddress;
	private double bill;
	
	public Customer() {
		
	}
	
	public Customer(int id, String name, String place, double bill) {
		this.cid=id;
		this.cname=name;
		this.caddress=place;
		this.bill=bill;
	}
}