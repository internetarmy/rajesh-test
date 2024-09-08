package com.internetarmy.dto;

import com.internetarmy.model.InvoiceItem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class InvoiceItemDto {
	
	private Integer id;
	private Integer invoiceId;
	private Integer serviceId;


	public InvoiceItemDto(InvoiceItem item) {
		this.id = item.getId();
		this.invoiceId = item.getInvoiceId();
		this.serviceId = item.getServiceId();
	}
	
}
