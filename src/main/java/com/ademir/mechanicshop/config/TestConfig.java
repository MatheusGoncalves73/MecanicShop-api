package com.ademir.mechanicshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ademir.mechanicshop.services.DbService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DbService dbService;

    @Bean
    void seedData() {
		System.out.println("Cheguei aqui");
		this.dbService.seedDataEntities();
	}
}
