package com.scs.ecommerce.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scs.ecommerce.exception.DataNotFoundException;
import com.scs.ecommerce.model.Customer;
import com.scs.ecommerce.model.Order;
import com.scs.ecommerce.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> findAll() {

		System.out.println("*** Inside Customer Service ******");

		List<Customer> customerList = customerRepository.findAll();
		
		System.out.println("list of customers :: "+customerList);
		
		return customerList;

	}

	public Customer findById(Long id) {

		System.out.println("*** Inside Customer Service findby id******");

		return customerRepository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("Customer Data not found for the ID :: " + id));

	}

	public Customer create(Customer customer) {
		
		
		System.out.println("Cusotmer object before saving is ::: "+customer);
		return customerRepository.save(customer);
	}

	public Customer update(Long id, Customer customer) {

		if (id == null || !id.equals(customer.getCustId())) {

			throw new DataNotFoundException("Invalid input Data for Update :: " + id);
		}
		return customerRepository.findById(id).map(existingCustomer -> customerRepository.save(customer))
				.orElseThrow(() -> new DataNotFoundException("Customer Data not found for the ID :: " + id));

	}

	public void delete(Long id) {

		java.util.Optional<Customer> cusomer = customerRepository.findById(id);

		if (cusomer.isPresent())
			customerRepository.delete(cusomer.get());
		else
			throw new DataNotFoundException("Customer Data not found for the ID :: " + id);

	}

}
