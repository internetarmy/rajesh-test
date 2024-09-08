package com.internetarmy.model;

import com.internetarmy.dto.InvoiceDto;

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
@Table(name = "invoice")
@NoArgsConstructor
@Setter
@Getter
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_id")
	private Integer invoiceId;
	
	@Column(name = "customer_id")
	private Integer customerId;
	
//	@Column(name = "invoice_id")
//	private Integer vehicleId;
	
	public Invoice(InvoiceDto invoice) {
		this.customerId = invoice.getCustomerId();
		this.invoiceId = invoice.getInvoiceId();
//		this.vehicleId = invoice.getVehicleId();
	}

}
