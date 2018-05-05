package com.dai.webServer.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class House {
	
	@Id
	@GeneratedValue
	private Long id_house;
	private String name;
	private Long account_id;
	
	public House() {
		super();
	}

	public House(Long id_house, String name, Long account_id) {
		super();
		this.id_house = id_house;
		this.name = name;
		this.account_id = account_id;
	}

	public Long getId_house() {
		return id_house;
	}

	public void setId_house(Long id_house) {
		this.id_house = id_house;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}
	
	
}
