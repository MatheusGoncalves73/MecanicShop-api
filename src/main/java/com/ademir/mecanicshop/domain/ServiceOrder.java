package com.ademir.mecanicshop.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "service_orders")
public class ServiceOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private LocalDate openDate;
	private LocalDate closeDate;
	private Double price;

	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	public ServiceOrder() {
	}

	public ServiceOrder(String description, LocalDate openDate, LocalDate closeDate, Double price, Vehicle vehicle) {
		super();
		this.description = description;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.price = price;
		this.vehicle = vehicle;
	}

	public ServiceOrder(Integer id, String description, LocalDate openDate, LocalDate closeDate, Double price,
			Vehicle vehicle) {
		super();
		this.id = id;
		this.description = description;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.price = price;
		this.vehicle = vehicle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public LocalDate getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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
		ServiceOrder other = (ServiceOrder) obj;
		return Objects.equals(id, other.id);
	}

}
