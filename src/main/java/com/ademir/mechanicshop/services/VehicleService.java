package com.ademir.mechanicshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ademir.mechanicshop.domain.Vehicle;
import com.ademir.mechanicshop.dtos.VehicleDTO;
import com.ademir.mechanicshop.repositories.CustomerRepository;
import com.ademir.mechanicshop.repositories.VehicleRepository;
import com.ademir.mechanicshop.services.exceptions.ObjectNotFoundException;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public Vehicle findById(Integer id) {
		Optional<Vehicle> obj = this.vehicleRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Veículo de id " + id + " não encontrado"));
	}

	public List<Vehicle> findAll() {
		return this.vehicleRepository.findAll();
	}

	public List<Vehicle> findAllByCustomerId(Integer customerId) {
		this.customerRepository.findById(customerId);
		return this.vehicleRepository.findAllByCustomer(customerId);
	}

	public Vehicle create(Vehicle obj) {
		obj.setId(null);
		return this.vehicleRepository.save(obj);
	}

	public Vehicle update(Integer id, VehicleDTO obj) {
		Vehicle newVehicle = this.findById(id);
		newVehicle.setPlate(obj.getPlate());
		newVehicle.setModel(obj.getModel());
		newVehicle.setYear(obj.getYear());
		this.vehicleRepository.save(newVehicle);
		return newVehicle;
	}

}
