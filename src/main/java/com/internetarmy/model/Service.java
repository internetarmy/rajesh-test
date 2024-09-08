package com.internetarmy.model;

import com.internetarmy.dto.ServiceDto;

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
@Table(name = "service")
@NoArgsConstructor
@Setter
@Getter
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
	private String id;
	
	@Column(name = "service_name")
	private String serviceName;
	
	@Column(name = "vehicle_type")
	private String vehicleType;

	Service(ServiceDto service) {
		this.id = service.getId();
		this.serviceName = service.getServiceName();
		this.vehicleType = service.getVehicleType();
	}
}
