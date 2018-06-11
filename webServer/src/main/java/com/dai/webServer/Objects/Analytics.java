package com.dai.webServer.Objects;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Analytics {
	
	@Id
	private int id;
	
	private String humidade;
	
	private int id_card;
	
	private int temperatura;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private java.sql.Timestamp dataI;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private java.sql.Timestamp dataF;
	
	private String idEntrada;
	
	
	public Analytics() {
		super();
	}


	public Analytics(int id, String humidade, int id_card, int temperatura, Timestamp dataI, Timestamp dataF,
			String idEntrada) {
		super();
		this.id = id;
		this.humidade = humidade;
		this.id_card = id_card;
		this.temperatura = temperatura;
		this.dataI = dataI;
		this.dataF = dataF;
		this.idEntrada = idEntrada;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHumidade() {
		return humidade;
	}


	public void setHumidade(String humidade) {
		this.humidade = humidade;
	}


	public int getId_card() {
		return id_card;
	}


	public void setId_card(int id_card) {
		this.id_card = id_card;
	}


	public int getTemperatura() {
		return temperatura;
	}


	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}


	public java.sql.Timestamp getDataI() {
		return dataI;
	}


	public void setDataI(java.sql.Timestamp dataI) {
		this.dataI = dataI;
	}


	public java.sql.Timestamp getDataF() {
		return dataF;
	}


	public void setDataF(java.sql.Timestamp dataF) {
		this.dataF = dataF;
	}


	public String getIdEntrada() {
		return idEntrada;
	}


	public void setIdEntrada(String idEntrada) {
		this.idEntrada = idEntrada;
	}
			

}
