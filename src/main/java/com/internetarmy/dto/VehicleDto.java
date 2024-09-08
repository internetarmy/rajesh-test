package com.internetarmy.dto;

import com.internetarmy.model.Vehicle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class VehicleDto {

	private Integer vehicleId;
	
	private String vehicleNumber;
	
	private String vehicleType;
	
	private Integer customerId;
	
	private Integer invoiceId;
	
	public VehicleDto(Vehicle vehicle) {
		this.vehicleId = vehicle.getVehicleId();
		this.vehicleNumber = vehicle.getVehicleNumber();
		this.vehicleType = vehicle.getVehicleType();
		this.customerId = vehicle.getCustomerId();
		this.invoiceId = vehicle.getInvoiceId();
	}
}
