package com.internetarmy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internetarmy.dto.CustomerDto;
import com.internetarmy.model.Customer;
import com.internetarmy.repo.CustomerRepo;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo repo;

	@Transactional
	public CustomerDto save(CustomerDto request) {
		Customer customer = new Customer(request);
		customer = repo.save(customer);
		request.setCustomerId(customer.getId());;
		return request;
	}
	
	public CustomerDto getCustomer(Integer id) {
		Customer customer = repo.getCustomer(id);
		CustomerDto dto = new CustomerDto(customer);
		return dto;
	}

}
