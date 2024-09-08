package com.internetarmy.dto;

import java.util.List;

import com.internetarmy.model.Invoice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class InvoiceDto {

	private Integer invoiceId;
	
	private Integer customerId;
	
	private List<InvoiceItemDto> items;

	private CustomerDto customer;
	
	public InvoiceDto(Invoice invoice) {
		this.customerId = invoice.getCustomerId();
		this.invoiceId = invoice.getInvoiceId();
	}
}
