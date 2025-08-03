package com.ademir.mechanicshop.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ademir.mechanicshop.domain.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	

//    @EntityGraph(attributePaths = "orders")
//    Optional<User> findWithOrdersById(Long id);
    
    
}
