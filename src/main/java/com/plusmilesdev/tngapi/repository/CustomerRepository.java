package com.plusmilesdev.tngapi.repository;

import java.util.List;

import com.plusmilesdev.tngapi.model.Customer;

public interface CustomerRepository {
	
	public List<Customer> findAll();
	
	public int save(Customer customer);

}
