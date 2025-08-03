package com.ademir.mechanicshop.dtos;

import java.io.Serializable;

import com.ademir.mechanicshop.domain.Vehicle;

public class VehicleDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String plate;
	private String model;
	private Integer year;

	public VehicleDTO() {
	}

	public VehicleDTO(Vehicle vehicle) {
		this.id = vehicle.getId();
		this.plate = vehicle.getPlate();
		this.model = vehicle.getModel();
		this.year = vehicle.getYear();
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

}
