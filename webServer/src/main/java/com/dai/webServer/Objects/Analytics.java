package com.dai.webServer.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Analytics {
	
	@Id
	private int id;
	
	private String humidade;
	
	private String temperatura;
	
	public Analytics() {
		super();
	}

	public Analytics(int id, String humidade, String temperatura) {
		super();
		this.id = id;
		this.humidade = humidade;
		this.temperatura = temperatura;
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

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	

}
