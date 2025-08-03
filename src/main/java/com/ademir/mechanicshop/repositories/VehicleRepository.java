package com.ademir.mechanicshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ademir.mechanicshop.domain.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

	@Query("SELECT v FROM vehicles v WHERE v.customer.id = :customerId")
	List<Vehicle> findAllByCustomer(@Param(value = "customerId") Integer customerId);

}
