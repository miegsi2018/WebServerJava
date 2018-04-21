package com.dai.webServer.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity

public class Sensor {
	
	
	@Id
	@GeneratedValue
	private long id_leitura;
	private int id_sensor;
	private double temperatura;
	private double humidade;
	private double ldr;
	private boolean gas;
	
	public Sensor(long id_leitura, int id_sensor, double temperatura, double humidade, double ldr, boolean gas) {
		super();
		this.id_leitura = id_leitura;
		this.id_sensor = id_sensor;
		this.temperatura = temperatura;
		this.humidade = humidade;
		this.ldr = ldr;
		this.gas = gas;
	}

	public long getId_leitura() {
		return id_leitura;
	}

	public void setId_leitura(long id_leitura) {
		this.id_leitura = id_leitura;
	}

	public int getId_sensor() {
		return id_sensor;
	}

	public void setId_sensor(int id_sensor) {
		this.id_sensor = id_sensor;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getHumidade() {
		return humidade;
	}

	public void setHumidade(double humidade) {
		this.humidade = humidade;
	}

	public double getLdr() {
		return ldr;
	}

	public void setLdr(double ldr) {
		this.ldr = ldr;
	}

	public boolean isGas() {
		return gas;
	}

	public void setGas(boolean gas) {
		this.gas = gas;
	}
	
	
}
