package com.internetarmy.dto;

import java.util.List;

import com.internetarmy.model.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {
	

	private Integer customerId;
	
	private String customerName;
	
	private String mobile;
	
	private List<VehicleDto> vehicle;
	
	public CustomerDto(Customer customer) {
		this.customerId = customer.getId();
		this.customerName = customer.getCustomerName();
		this.mobile = customer.getMobile();
	}

}
