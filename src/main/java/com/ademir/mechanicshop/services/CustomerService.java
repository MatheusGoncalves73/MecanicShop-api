package com.ademir.mechanicshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ademir.mechanicshop.domain.Customer;
import com.ademir.mechanicshop.repositories.CustomerRepository;
import com.ademir.mechanicshop.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer findById(Integer id) {
		Optional<Customer> obj = this.customerRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente de id " + id +  " não encontrado"));
	}

	public Customer findByIdWithVehicles(Integer id) {
		return this.customerRepository.findById(id).map((customer) -> {
			customer.getVehicles().size();
			return customer;
		}).orElse(null);
//		return null;
	}
}
