package com.internetarmy.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.internetarmy.model.Invoice;
import com.internetarmy.model.InvoiceItem;
import com.internetarmy.model.Vehicle;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class InvoiceRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	public <T> T save(T invoice) {
		return em.merge(invoice);
	}

	public Invoice getInvoice(Integer invoiceId) {
		Query query = em.createNativeQuery("select * from invoice where invoice_id = :id", Invoice.class);
		query.setParameter("id", invoiceId);
		return (Invoice) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Vehicle> getVehicle(Integer invoiceId){
		Query query = em.createNativeQuery("select * from vehicle where invoice_id = :id", Vehicle.class);
		query.setParameter("id", invoiceId);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<InvoiceItem> getInvoiceItem(Integer invoiceId) {
		Query query = em.createNativeQuery("select * from invoice_items where invoice_id = :id" , InvoiceItem.class);
		query.setParameter("id", invoiceId);
		return query.getResultList();
	}

}
