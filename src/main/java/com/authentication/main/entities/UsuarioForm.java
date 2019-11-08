package com.authentication.main.entities;

import java.util.Date;

/*
 * Nombre de la clase: UsuarioForm
 * Fecha: 3/11/2019
 * Versión: 1.0
 * CopyRight: 
 * Autor: Téc. Balmore Pérez
 */
public class UsuarioForm {
	
	//Atributos de la clase
	private Long id;
	private String name;	
	private String apellido;
	private String telefono;
	private String email;
	private String password;
	private Date fechaNacimiento;
	private String sexo;
	private String nombreContactoEmergencia;
	private String numeroContactoEmergencia;
	
	//Métodos constructores
	public UsuarioForm() {
		
	}
	
	public UsuarioForm(String name, String apellido, String telefono, String email, String password, 
			String sexo, String nombreContactoEmergencia, String numeroContactoEmergencia)
	{
		this.name = name;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.sexo = sexo;
		this.nombreContactoEmergencia = nombreContactoEmergencia;
		this.numeroContactoEmergencia = numeroContactoEmergencia;
	}
	
	//Métodos Getter y Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNombreContactoEmergencia() {
		return nombreContactoEmergencia;
	}

	public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
		this.nombreContactoEmergencia = nombreContactoEmergencia;
	}

	public String getNumeroContactoEmergencia() {
		return numeroContactoEmergencia;
	}

	public void setNumeroContactoEmergencia(String numeroContactoEmergencia) {
		this.numeroContactoEmergencia = numeroContactoEmergencia;
	}
}
