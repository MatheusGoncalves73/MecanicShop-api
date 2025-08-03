package com.ademir.mechanicshop.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping()
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		customer = this.customerService.create(customer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(customer.getId()).toUri();
		return ResponseEntity.created(uri).body(customer);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> update(@PathVariable Integer id, @RequestBody CustomerDTO objDTO){
		Customer customer = this.customerService.update(id,objDTO);
		return ResponseEntity.ok().body(new CustomerDTO(customer));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		this.customerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
