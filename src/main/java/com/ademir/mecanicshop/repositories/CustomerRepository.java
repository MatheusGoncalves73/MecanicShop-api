package com.ademir.mecanicshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademir.mecanicshop.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
