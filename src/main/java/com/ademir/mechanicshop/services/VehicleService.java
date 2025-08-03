package com.ademir.mechanicshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ademir.mechanicshop.domain.Vehicle;
import com.ademir.mechanicshop.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public Vehicle findById(Integer id) {
		Optional<Vehicle> obj = this.vehicleRepository.findById(id);
		return obj.orElse(null);
	}

}
