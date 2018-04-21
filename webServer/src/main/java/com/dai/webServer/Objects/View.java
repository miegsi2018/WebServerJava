package com.dai.webServer.Objects;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@NamedQuery(name = "View.findThem", query = "SELECT DISTINCT p FROM View p WHERE p.email = ?1")
@Table(name = "contas_v")
public class View {
	
@Email
@Id
@GeneratedValue	
	
private int id_casa;
private int a_user;
private int a_casa;
private int id_utilizador;
private String email;
private String casa;
private int id_divisao;
private String divisao;
private Long sensor;


public View() {
	super();
}



public View(@Email int id_casa, int a_user, int a_casa, int id_utilizador, String email, String casa, int id_divisao,
		String divisao, Long sensor) {
	super();
	this.id_casa = id_casa;
	this.a_user = a_user;
	this.a_casa = a_casa;
	this.id_utilizador = id_utilizador;
	this.email = email;
	this.casa = casa;
	this.id_divisao = id_divisao;
	this.divisao = divisao;
	this.sensor = sensor;
}



public int getId_casa() {
	return id_casa;
}



public void setId_casa(int id_casa) {
	this.id_casa = id_casa;
}



public int getA_user() {
	return a_user;
}



public void setA_user(int a_user) {
	this.a_user = a_user;
}



public int getA_casa() {
	return a_casa;
}



public void setA_casa(int a_casa) {
	this.a_casa = a_casa;
}



public int getId_utilizador() {
	return id_utilizador;
}



public void setId_utilizador(int id_utilizador) {
	this.id_utilizador = id_utilizador;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getCasa() {
	return casa;
}



public void setCasa(String casa) {
	this.casa = casa;
}



public int getId_divisao() {
	return id_divisao;
}



public void setId_divisao(int id_divisao) {
	this.id_divisao = id_divisao;
}



public String getDivisao() {
	return divisao;
}



public void setDivisao(String divisao) {
	this.divisao = divisao;
}



public Long getSensor() {
	return sensor;
}



public void setSensor(Long sensor) {
	this.sensor = sensor;
}


	
	
	
}
