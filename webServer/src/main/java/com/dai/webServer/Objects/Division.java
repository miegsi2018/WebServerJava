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
	private String sensor_id;
	private Integer path;
	
	public Division(Long id_division, Long id_house, String name, String sensor_id, Integer path) {
		super();
		this.id_division = id_division;
		this.id_house = id_house;
		this.name = name;
		this.sensor_id = sensor_id;
		this.path = path;
	}

	public Integer getPath() {
		return path;
	}

	public void setPath(Integer path) {
		this.path = path;
	}

	public Division() {
		super();
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

	public String getSensor_id() {
		return sensor_id;
	}

	public void setSensor_id(String sensor_id) {
		this.sensor_id = sensor_id;
	}

	public Long getId_house() {
		return id_house;
	}

	public void setId_house(Long id_house) {
		this.id_house = id_house;
	}
	
	
}
