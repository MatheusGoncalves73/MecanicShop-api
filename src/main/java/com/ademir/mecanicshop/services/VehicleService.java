package com.ademir.mecanicshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ademir.mecanicshop.domain.Vehicle;
import com.ademir.mecanicshop.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public Vehicle findById(Integer id) {
		Optional<Vehicle> obj = this.vehicleRepository.findById(id);
		return obj.orElse(null);
	}

}
