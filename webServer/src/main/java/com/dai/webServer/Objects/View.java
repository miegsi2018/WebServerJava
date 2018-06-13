package com.dai.webServer.Objects;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@NamedQuery(name = "View.findThem", query = "SELECT DISTINCT p FROM View p WHERE p.email = ?1")
@Table(name = "v_contas")
public class View {
	
@Email
@Id
@GeneratedValue	
private int id_account;	
private int id_division;
private int id_house;
private String email;
private  String type;
private Long stype;



private String house;
private String division;
private String sensor_id;


public View() {
	super();
}





public View(@Email int id_account, int id_division, int id_house, String email, String type,Long stype,  String house,String division, String sensor_id) {
	super();
	this.id_account = id_account;
	this.id_division = id_division;
	this.id_house = id_house;
	this.email = email;
	this.type = type;
	this.stype = stype;
	this.house = house;
	this.division = division;
	this.sensor_id = sensor_id;
}





public int getId_division() {
	return id_division;
}


public void setId_division(int id_division) {
	this.id_division = id_division;
}


public int getId_house() {
	return id_house;
}


public void setId_house(int id_house) {
	this.id_house = id_house;
}


public Long getSensorType() {
	return stype;
}


public void setSensorType(Long stype) {
	
	this.stype = stype;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


public String getHouse() {
	return house;
}


public void setHouse(String house) {
	this.house = house;
}


public String getDivision() {
	return division;
}


public void setDivision(String division) {
	this.division = division;
}


public String getSensor_id() {
	return sensor_id;
}


public void setSensor_id(String sensor_id) {
	this.sensor_id = sensor_id;
}





public int getId_account() {
	return id_account;
}





public void setId_account(int id_account) {
	this.id_account = id_account;
}






}
