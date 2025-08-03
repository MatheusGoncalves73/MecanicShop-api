package com.ademir.mecanicshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ademir.mecanicshop.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
