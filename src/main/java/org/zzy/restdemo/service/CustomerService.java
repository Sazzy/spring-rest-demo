package org.zzy.restdemo.service;

import org.zzy.restdemo.model.Customer;

import java.util.List;

public interface CustomerService {
	Customer getById(Long id);

	void save(Customer customer);

	void deleteById(Long id);

	List<Customer> getAll();
}
