package com.ademir.mechanicshop.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "vehicles")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Número da placa do veículo é obrigatório")
	@Length(min = 7, max = 7, message = "A placa do veículo deve ter 7 caracteres")
	private String plate;
	
	@NotEmpty(message = "O modelo do veículo é obrigatório")
	private String model;

	@NotNull(message = "O ano do veículo é obrigatório")
	@Min(message = "O ano do carro deve ser de no mínimo 1900", value = 1900)
	private Integer year;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Vehicle() {
	}

	public Vehicle(String plate, String model, Integer year, Customer customer) {
		super();
		this.plate = plate;
		this.model = model;
		this.year = year;
		this.customer = customer;
	}

	public Vehicle(Integer id, String plate, String model, Integer year) {
		super();
		this.id = id;
		this.plate = plate;
		this.model = model;
		this.year = year;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(id, other.id);
	}

}
