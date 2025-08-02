package com.ademir.mecanicshop.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademir.mecanicshop.domain.ServiceOrder;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {

}
