package com.ademir.mechanicshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ademir.mechanicshop.domain.Vehicle;
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

}
