package com.internetarmy.repo;

import org.springframework.stereotype.Repository;

import com.internetarmy.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class CustomerRepo {

	@PersistenceContext
	private EntityManager em;
	
	public Customer save(Customer customer) {
		return em.merge(customer);
	}
	
	public Customer getCustomer(Integer id) {
		if(id == null) {
			return null;
		}
		Query query = em.createNativeQuery("select * from customer where customer_id = :id", Customer.class);
		query.setParameter("id", id);
		return (Customer) query.getSingleResult();
	}

}

