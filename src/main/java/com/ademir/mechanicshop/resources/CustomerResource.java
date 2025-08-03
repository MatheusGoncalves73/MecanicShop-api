package com.ademir.mechanicshop.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ademir.mechanicshop.domain.Customer;
import com.ademir.mechanicshop.dtos.CustomerDTO;
import com.ademir.mechanicshop.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Integer id) {
		Customer obj = this.customerService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping()
	public ResponseEntity<List<CustomerDTO>> findAll() {
		List<CustomerDTO> customersDTO = this.customerService.findAll().stream()
				.map((customer) -> new CustomerDTO(customer)).collect(Collectors.toList());
		return ResponseEntity.ok().body(customersDTO);
	}

}
