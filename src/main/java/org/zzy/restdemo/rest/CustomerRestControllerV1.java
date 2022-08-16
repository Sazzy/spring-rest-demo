package org.zzy.restdemo.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zzy.restdemo.model.Customer;
import org.zzy.restdemo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerRestControllerV1 {
	private final CustomerService customerService;

	public CustomerRestControllerV1(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId) {
		if (customerId == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Customer customer = this.customerService.getById(customerId);
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> saveCustomer(@RequestBody @Validated Customer customer) {
		HttpHeaders headers = new HttpHeaders();
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		this.customerService.save(customer);
		return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
	}

	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody @Validated Customer customer) {
		HttpHeaders headers = new HttpHeaders();
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		this.customerService.save(customer);
		return new ResponseEntity<>(customer, headers, HttpStatus.OK);
	}

	@DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long customerId) {
		if (customerId == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Customer customer = customerService.getById(customerId);
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.customerService.deleteById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = this.customerService.getAll();
		if (customers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
