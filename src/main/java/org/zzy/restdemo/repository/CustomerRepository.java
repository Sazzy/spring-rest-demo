package org.zzy.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zzy.restdemo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
