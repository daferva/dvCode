package com.davidwebtest.model;

import java.util.HashMap;

/**
 * 
 * @author DavidV
 *
 */
public abstract class Matriz {
	protected int alto, ancho;
	protected String sContenido;
	public Matriz(int alto, int ancho, String sContenido) {
		this.alto = alto;
		this.ancho = ancho;
		this.sContenido = sContenido;
	}
	public abstract String[][] ordenarAscendente();
	public abstract HashMap<String, Integer> consultarOcurrencias();
	public abstract String[][] eliminarRepetidos();
	public abstract void imprimirMatriz();
}