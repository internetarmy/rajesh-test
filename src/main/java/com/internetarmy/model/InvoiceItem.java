package com.internetarmy.model;

import com.internetarmy.dto.InvoiceItemDto;

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
@Table(name = "invoice_items")
@NoArgsConstructor
@Setter
@Getter
public class InvoiceItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inv_item_id")
	private Integer id;
	@Column(name = "invoice_id")
	private Integer invoiceId;
	@Column(name = "service_id")
	private Integer serviceId;

	public InvoiceItem(InvoiceItemDto item) {
		this.serviceId = item.getServiceId();
		this.invoiceId = item.getInvoiceId();
	}
	
	
}
