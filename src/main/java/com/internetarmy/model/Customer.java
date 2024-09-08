package com.internetarmy.model;

import com.internetarmy.dto.CustomerDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Setter
@Getter
public class Customer {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "mobile")
	private String mobile;
	
	public Customer(CustomerDto request) {
		this.customerName = request.getCustomerName();
		this.mobile = request.getMobile();
	}
	
	

}
