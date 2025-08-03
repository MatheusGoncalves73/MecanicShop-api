package com.ademir.mechanicshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ademir.mechanicshop.domain.Customer;
import com.ademir.mechanicshop.dtos.CustomerDTO;
import com.ademir.mechanicshop.repositories.CustomerRepository;
import com.ademir.mechanicshop.services.exceptions.DataIntegrityException;
import com.ademir.mechanicshop.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer findById(Integer id) {
		Optional<Customer> obj = this.customerRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente de id " + id + " não encontrado"));
	}

	public List<Customer> findAll() {
		return this.customerRepository.findAll();
	}

	public Customer create(Customer obj) {
		obj.setId(null);
		return this.customerRepository.save(obj);
	}

	public Customer update(Integer id, CustomerDTO objDTO) {
		Customer customer = this.findById(id);
		customer.setName(objDTO.getName());
		customer.setEmail(objDTO.getEmail());
		customer.setPhone(objDTO.getPhone());
		return customer;
	}
	
	public void delete(Integer id) {
		try {
			Customer obj = this.findById(id);
			this.customerRepository.delete(obj);;	
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cliente não pode ser deletado pois possui veículos associados");
		}
		
	}

}
