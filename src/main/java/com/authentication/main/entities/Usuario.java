package com.authentication.main.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Nombre de la clase: Usuario
 * Fecha: 3/11/2019
 * Versión: 1.0
 * CopyRight: 
 * Autor: Téc. Balmore Pérez
 */

@Entity
@Table(name = "cadb_tbusuario")
public class Usuario {
	
	//Atributos de la clase
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbusuario_id")
    private Long id;

    @Column(name = "tbusuario_nombre", unique = true)
    private String name;
    
    @Column(name = "tbusuario_apellido")
    private String apellido;
    
    @Column(name = "tbusuario_telefono")
    private String telefono;
    
    @Column(name = "tbusuario_email", unique =  true)
    private String email;
    
    @Column(name = "tbusuario_contrasenhia")
    private String password;
    
    @Temporal(TemporalType.DATE)
    @Column(name = " tb_usuario_fecha_nacimiento")
    private Date fechaNacimiento;
    
    @Column(name = "tbusuario_sexo")
    private String sexo;
    
    @Column(name = "tbusuario_nombre_contacto_emergencia")
    private String nombreContactoEmergencia;
    
    @Column(name = "tbusuario_numero_contacto_emergencia")
    private String numeroContactoEmergencia;
    
    @Column(name = "tbusuario_estado")
    private boolean enabled;
    
    //Métodos constructores
    public Usuario(){}

    public Usuario(String name, String apellido, String telefono, String email, String password, Date fechaNacimiento, 
    		String sexo, String nombreContactoEmergencia, String numeroContactoEmergencia,  boolean enabled) {
        this.name = name;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.nombreContactoEmergencia = nombreContactoEmergencia;
        this.numeroContactoEmergencia = numeroContactoEmergencia;
        this.enabled = enabled;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
