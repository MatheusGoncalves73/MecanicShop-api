package com.ademir.mechanicshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ademir.mechanicshop.domain.Customer;
import com.ademir.mechanicshop.domain.Vehicle;
import com.ademir.mechanicshop.dtos.VehicleDTO;
import com.ademir.mechanicshop.repositories.VehicleRepository;
import com.ademir.mechanicshop.services.exceptions.DataIntegrityException;
import com.ademir.mechanicshop.services.exceptions.ObjectNotFoundException;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;


	@Autowired
	private CustomerService customerService;
	
	public Vehicle findById(Integer id) {
		Optional<Vehicle> obj = this.vehicleRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Veículo de id " + id + " não encontrado"));
	}

	public List<Vehicle> findAll() {
		return this.vehicleRepository.findAll();
	}

	public List<Vehicle> findAllByCustomerId(Integer customerId) {
		this.customerService.findById(customerId);
		return this.vehicleRepository.findAllByCustomer(customerId);
	}

	public Vehicle create(Integer customerId, Vehicle obj) {
		Customer customer = this.customerService.findById(customerId);
		obj.setId(null);
		obj.setCustomer(customer);
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

	public void delete(Integer id) {
		try {
			Vehicle obj = this.findById(id);
			this.vehicleRepository.delete(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Veículo não pode ser deletado pois possui ordens de serviço associadas");
		}
	}

}
