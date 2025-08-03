package com.ademir.mechanicshop.dtos;

import java.io.Serializable;

import com.ademir.mechanicshop.domain.Customer;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;
	private String phone;

	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.email = customer.getEmail();
		this.phone = customer.getPhone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
