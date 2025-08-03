package com.ademir.mechanicshop.services;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ademir.mechanicshop.domain.Customer;
import com.ademir.mechanicshop.domain.ServiceOrder;
import com.ademir.mechanicshop.domain.Vehicle;
import com.ademir.mechanicshop.repositories.CustomerRepository;
import com.ademir.mechanicshop.repositories.ServiceOrderRepository;
import com.ademir.mechanicshop.repositories.VehicleRepository;

@Service
public class DbService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private ServiceOrderRepository serviceOrderRepository;

	public void seedDataEntities() {
		Customer c1 = new Customer("Matheus Gonçalves", "matheus57.ruiz100@gmail.com", "44999711221");
		Customer c2 = new Customer("Lucas Martins", "lucasmartins@outlook.com", "44999761229");
		Customer c3 = new Customer("Tiago Martins", "tiagomartins@outlook.com", "44999118889");

		Vehicle v1 = new Vehicle("ABC1234", "Toyota Corolla", 2015, c1);
		Vehicle v2 = new Vehicle("DDC1222", "Civic", 2020, c1);
		Vehicle v3 = new Vehicle("LLC7112", "Ford Honda", 2010, c1);
		Vehicle v4 = new Vehicle("XYZ9876", "Honda Civic", 2022, c2);

		ServiceOrder s1 = new ServiceOrder("Troca de óleo", LocalDate.of(2025, 6, 8), LocalDate.of(2025, 6, 11), 100.55,
				v2);
		ServiceOrder s2 = new ServiceOrder("Alinhamento e balanceamento", LocalDate.of(2025, 6, 11),
				LocalDate.of(2025, 6, 11), 200.29, v1);

		ServiceOrder s3 = new ServiceOrder("Troca de pastilhas de freio", LocalDate.of(2025, 6, 18),
				LocalDate.of(2025, 6, 19), 400.29, v1);

		customerRepository.saveAll(Arrays.asList(c1, c2, c3));
		vehicleRepository.saveAll(Arrays.asList(v1, v2, v3, v4));
		serviceOrderRepository.saveAll(Arrays.asList(s1, s2, s3));

	}
}
