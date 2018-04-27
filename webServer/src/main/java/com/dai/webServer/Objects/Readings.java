package com.dai.webServer.Objects;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.json.simple.JSONObject;


@Entity


@Table(name = "readings")
public class Readings {
	
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String attr;

    @Column(name="data")
	private java.sql.Timestamp data;
	
	public Readings() {
		super();
			}

	public Readings(int id, String attr, Timestamp data) {
		super();
		this.id = id;
		this.attr = attr;
		this.data = data;
	}

	public Readings(JSONObject attr) {
		
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
