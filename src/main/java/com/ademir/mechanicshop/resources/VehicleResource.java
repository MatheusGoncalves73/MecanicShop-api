package com.ademir.mechanicshop.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ademir.mechanicshop.domain.Vehicle;
import com.ademir.mechanicshop.dtos.VehicleDTO;
import com.ademir.mechanicshop.services.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleResource {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> findById(@PathVariable Integer id) {
		Vehicle obj = this.vehicleService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping()
	public ResponseEntity<List<VehicleDTO>> findAll() {
		List<VehicleDTO> vehiclesDTO = this.vehicleService.findAll().stream().map((vehicle) -> new VehicleDTO(vehicle))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(vehiclesDTO);
	}

	@GetMapping("/customer")
	public ResponseEntity<List<VehicleDTO>> findByCustomerId(
			@RequestParam(value = "customer", defaultValue = "0") Integer customerId) {
		List<Vehicle> vehicles = this.vehicleService.findAllByCustomerId(customerId);
		List<VehicleDTO> vehiclesDTO = vehicles.stream().map((vehicle) -> new VehicleDTO(vehicle))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(vehiclesDTO);
	}

	@PostMapping()
	public ResponseEntity<Vehicle> create(@RequestBody Vehicle obj) {
		Vehicle vehicle = this.vehicleService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/vehicles/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(vehicle);
	}

}
