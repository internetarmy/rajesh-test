package com.internetarmy.model;

import com.internetarmy.dto.VehicleDto;

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
@Table(name = "vehicle")
@NoArgsConstructor
@Setter
@Getter
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Integer vehicleId;
	
	@Column(name = "vehicle_number")
	private String vehicleNumber;
	
	@Column(name = "vehicle_type")
	private String vehicleType;
	
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Column(name = "invoice_id")
	private Integer invoiceId;
	
	public Vehicle(VehicleDto vehicle) {
		this.vehicleId = vehicle.getVehicleId();
		this.vehicleNumber = vehicle.getVehicleNumber();
		this.vehicleType = vehicle.getVehicleType();
		this.customerId = vehicle.getCustomerId();
		this.invoiceId = vehicle.getInvoiceId();
	}
}
