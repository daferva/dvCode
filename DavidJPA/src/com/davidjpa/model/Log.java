package com.davidjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the log database table.
 * 
 */
@Entity
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String fecha;

	@Column(name="trama_in")
	private String tramaIn;

	@Column(name="trama_out")
	private String tramaOut;

	private String usuario;

	public Log() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTramaIn() {
		return this.tramaIn;
	}

	public void setTramaIn(String tramaIn) {
		this.tramaIn = tramaIn;
	}

	public String getTramaOut() {
		return this.tramaOut;
	}

	public void setTramaOut(String tramaOut) {
		this.tramaOut = tramaOut;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}