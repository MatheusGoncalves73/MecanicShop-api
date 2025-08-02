package com.ademir.mecanicshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademir.mecanicshop.domain.ServiceOrder;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {

}
