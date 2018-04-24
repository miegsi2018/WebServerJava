package com.dai.webServer.Objects;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity


@Table(name = "readings")
public class Readings {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String attr;
	
	private Timestamp data;
	
	public Readings(){}

	public Readings(int id, String attr, Timestamp data) {
		super();
		this.id = id;
		this.attr = attr;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}
	
}
