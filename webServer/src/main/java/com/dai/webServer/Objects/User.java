package com.dai.webServer.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity



@NamedQuery(name = "User.findByEmail", query = "SELECT p FROM User p WHERE LOWER(p.email) = LOWER(?1)")
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue

	@Column(nullable = true)
	private Long id_user;

	private String username;
	private String address;
	private String contact;
	private String nif;
	private String email;
	private String regdate;
	private String password;
	private String type;
	private String active;
	
	public User() {
		super();
	}

	public User(Long id_user, String username, String address, String contact, String nif, String email, String regdate, String password, String type, String active) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.address = address;
		this.contact = contact;
		this.nif = nif;
		this.email = email;
		this.regdate = regdate;
		this.password = password;
		this.type = type;
		this.active = active;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}

