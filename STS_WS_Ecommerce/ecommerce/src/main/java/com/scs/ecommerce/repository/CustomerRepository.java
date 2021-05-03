package com.scs.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scs.ecommerce.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
