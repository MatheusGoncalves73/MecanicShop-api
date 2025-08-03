package com.ademir.mecanicshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ademir.mecanicshop.domain.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
}
