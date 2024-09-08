package com.internetarmy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internetarmy.dto.CustomerDto;
import com.internetarmy.dto.InvoiceDto;
import com.internetarmy.dto.InvoiceItemDto;
import com.internetarmy.dto.VehicleDto;
import com.internetarmy.model.Invoice;
import com.internetarmy.model.InvoiceItem;
import com.internetarmy.model.Vehicle;
import com.internetarmy.repo.InvoiceRepo;

import jakarta.transaction.Transactional;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepo invRepo;

	@Autowired
	private CustomerService customerService;

	@Transactional
	public InvoiceDto createInvoice(InvoiceDto request) {
		//Create Customer
		CustomerDto customer = customerService.save(request.getCustomer());

		// Create Invoice
		request.setCustomerId(customer.getCustomerId());
		Invoice invoice = new Invoice(request);
		invoice = invRepo.save(invoice);
		request.setInvoiceId(invoice.getInvoiceId());

		// Create Vehicles brought by customer
		for (VehicleDto dto : request.getCustomer().getVehicle()) {
			dto.setCustomerId(customer.getCustomerId());
			dto.setInvoiceId(invoice.getInvoiceId());
			Vehicle vehicle = new Vehicle(dto);
			Vehicle save = invRepo.save(vehicle);
			dto.setVehicleId(save.getVehicleId());
		}

		//create Invoice items which is used for bill by each service cost.
		for (InvoiceItemDto dto : request.getItems()) {
			dto.setInvoiceId(invoice.getInvoiceId());
			InvoiceItem item = new InvoiceItem(dto);
			item = invRepo.save(item);
			dto.setId(item.getId());
		}
		return request;
	}

	public InvoiceDto getInvoice(Integer invoiceId) {
		//find invoice main table info
		Invoice inv = invRepo.getInvoice(invoiceId);
		
		InvoiceDto invoice = new InvoiceDto(inv);
		
		//find customer info
		CustomerDto customer = customerService.getCustomer(inv.getCustomerId());
		
		//find Vehicle info
		List<Vehicle> vehicle = invRepo.getVehicle(invoiceId);
		if(vehicle != null && !vehicle.isEmpty()) {
			List<VehicleDto> collect = vehicle.stream().map(v -> new VehicleDto(v)).collect(Collectors.toList());
			customer.setVehicle(collect);
		}
		
		invoice.setCustomer(customer);
		
		// find invoice Items
		List<InvoiceItem> invoiceItems = invRepo.getInvoiceItem(invoiceId);
		if(invoiceItems != null && !invoiceItems.isEmpty()) {
			List<InvoiceItemDto> collect = invoiceItems.stream().map(i -> new InvoiceItemDto(i)).collect(Collectors.toList());
			invoice.setItems(collect);
		}
		return invoice;
	}

}
