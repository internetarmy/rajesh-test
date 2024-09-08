package com.internetarmy.dto;

import com.internetarmy.model.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ServiceDto {
	
	private String id;
	
	private String serviceName;
	
	private String vehicleType;

	ServiceDto(Service service) {
		this.id = service.getId();
		this.serviceName = service.getServiceName();
		this.vehicleType = service.getVehicleType();
	}
}
