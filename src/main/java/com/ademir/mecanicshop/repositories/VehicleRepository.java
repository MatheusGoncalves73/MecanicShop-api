package com.ademir.mecanicshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademir.mecanicshop.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
}
