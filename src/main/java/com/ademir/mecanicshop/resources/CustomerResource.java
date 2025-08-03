package com.ademir.mecanicshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ademir.mecanicshop.domain.Customer;
import com.ademir.mecanicshop.services.CustomerService;

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

}
