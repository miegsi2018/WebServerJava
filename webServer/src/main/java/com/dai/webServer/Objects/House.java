package com.dai.webServer.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@NamedQuery(name = "House.findById", query = "SELECT p FROM House p WHERE p.id_house = ?1")
@Table(name = "house")
public class House {
	
	@Id
	@GeneratedValue
	private Long id_house;
	private String name;
	private Long account_id;
	private Integer path;
	
	public House() {
		super();
	}

	public House(Long id_house, String name, Long account_id, Integer path) {
		super();
		this.id_house = id_house;
		this.name = name;
		this.account_id = account_id;
		this.path = path;
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

	public Integer getPath() {
		return path;
	}

	public void setPath(Integer path) {
		this.path = path;
	}
		
}
