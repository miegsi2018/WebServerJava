package com.dai.webServer.Utilizador;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity



@NamedQuery(name = "Utilizador.findByEmail", query = "SELECT p FROM Utilizador p WHERE LOWER(p.email) = LOWER(?1)")
@Table(name = "utilizador")
public class Utilizador {
	@Email
	@Id
	@GeneratedValue
	private Long id_utilizador;
	private String username;
	private String morada;
	private String contacto;
	private String nif;
	private String email;
	private String data;
	private String main;
	private String password;
	private String type;
	private String ativa;
	
	public Utilizador() {
		super();
	}

	public Utilizador(Long id_utilizador, String username, String morada, String contacto, String nif, String email,
			String data, String main, String password, String type, String ativa) {
		super();
		this.id_utilizador = id_utilizador;
		this.username = username;
		this.morada = morada;
		this.contacto = contacto;
		this.nif = nif;
		this.email = email;
		this.data = data;
		this.main = main;
		this.password = password;
		this.type = type;
		this.ativa = ativa;
	}

	public Long getId_utilizador() {
		return id_utilizador;
	}

	public void setId_utilizador(Long id_utilizador) {
		this.id_utilizador = id_utilizador;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
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

	public String getAtiva() {
		return ativa;
	}

	public void setAtiva(String ativa) {
		this.ativa = ativa;
	}

	@Override
	public String toString() {
		return "Utilizador [id_utilizador=" + id_utilizador + ", username=" + username + ", morada=" + morada
				+ ", contacto=" + contacto + ", nif=" + nif + ", email=" + email + ", data=" + data + ", main=" + main
				+ ", password=" + password + ", type=" + type + ", ativa=" + ativa + "]";
	}

}

