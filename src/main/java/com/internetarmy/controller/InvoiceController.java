package com.internetarmy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internetarmy.dto.InvoiceDto;
import com.internetarmy.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService service;
	
	@PostMapping
	public InvoiceDto createInvoice(@RequestBody InvoiceDto request) {
		return service.createInvoice(request);
	}
	
	@GetMapping("/{invoiceId}")
	public InvoiceDto getInvoice(@PathVariable Integer invoiceId) {
		return service.getInvoice(invoiceId);
	}

}
