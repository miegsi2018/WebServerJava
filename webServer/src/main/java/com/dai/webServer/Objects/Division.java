package com.dai.webServer.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Division {
	
	
	@Id
	@GeneratedValue
	private Long id_division;
	private Long id_house;
	private String name;
	private Long sensor_id;
	
	public Division() {
		super();
	}

	public Division(Long id_division, Long id_house, String name, Long sensor_id) {
		super();
		this.id_division = id_division;
		this.id_house = id_house;
		this.name = name;
		this.sensor_id = sensor_id;
	}

	public Long getId_division() {
		return id_division;
	}

	public void setId_division(Long id_division) {
		this.id_division = id_division;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSensor_id() {
		return sensor_id;
	}

	public void setSensor_id(Long sensor_id) {
		this.sensor_id = sensor_id;
	}

	public Long getId_house() {
		return id_house;
	}

	public void setId_house(Long id_house) {
		this.id_house = id_house;
	}
	
	
}
