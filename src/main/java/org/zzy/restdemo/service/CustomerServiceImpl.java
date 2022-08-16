package org.zzy.restdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zzy.restdemo.model.Customer;
import org.zzy.restdemo.repository.CustomerRepository;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer getById(Long id) {
		log.info("CustomerServiceImpl getById {}", id);
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Customer customer) {
		log.info("CustomerServiceImpl save {}", customer);
		customerRepository.save(customer);
	}

	@Override
	public void deleteById(Long id) {
		log.info("CustomerServiceImpl deleteById {}", id);
		customerRepository.deleteById(id);
	}

	@Override
	public List<Customer> getAll() {
		log.info("CustomerServiceImpl getAll");
		return customerRepository.findAll();
	}
}
