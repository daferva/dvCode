package com.davidwebtest.model;

import java.util.HashMap;
import java.util.Map;

public class Letras extends Matriz{
	
	String matriz[][];
	
	public Letras(int alto, int ancho, String sContenido) {
		super(alto, ancho, sContenido);
		matriz = new String[this.alto][this.ancho];
		llenarMatriz();
	}

	private void llenarMatriz() {
		char cContenido[] = this.sContenido.toCharArray();
		int i = 0;
		for (int f = 0; f < this.alto; f++) {
			for (int c = 0; c < this.ancho; c++) {
				this.matriz[f][c]=Character.toString(cContenido[i]);
				i++;
			}
		}
	}
	
	@Override
	public void imprimirMatriz() {
		
		for (int f = 0; f < this.alto; f++) {
			for (int c = 0; c < this.ancho; c++) {
				System.out.print(this.matriz[f][c]);
			}
			System.out.print('\n');
		}
	}

	@Override
	/**
	 * Ordena los elementos de la matriz ascendentemente
	 */
	public String[][] ordenarAscendente() {
		String aux;
		
		for( int f = 0; f < this.alto; f++){
			for( int c = 0; c < this.ancho; c++){
				for(int i = 0; i < this.alto; i++){
					for(int j = 0; j <this.ancho; j++){
						if(this.matriz[f][c].compareTo(this.matriz[i][j])<0){
							aux = this.matriz[f][c];
							this.matriz[f][c] = this.matriz[i][j];
							this.matriz[i][j] = aux;
						}
					}
				}
			}
		}
		return this.matriz;
	}

	@Override
	/**
	 * Consulta los elementos repetidos en la matriz
	 */
	public HashMap<String, Integer> consultarOcurrencias() {
		
		return elementosUnicosMatriz();
	}

	@Override
	public String[][] eliminarRepetidos() {
		
		HashMap<String, Integer> ocurrencias = elementosUnicosMatriz();

		//Recorrido de la matriz para contar las ocurrencias
		for (Map.Entry<String, Integer> valor : ocurrencias.entrySet()) {
			if(valor.getValue()>1) {
				int cuenta = valor.getValue();
				for (int f = 0; f < this.alto; f++) {
					for (int c = 0; c < this.ancho; c++) {
						if(valor.getKey().equals(this.matriz[f][c]) && cuenta > 1) {
							this.matriz[f][c] = "*";
							cuenta--;
						}
						
					}
				}
			}
		}
		
		matriz.toString();
		return null;
	}
	
	/**
	 * Método que consulta los elementos de la matriz y el numero de veces 
	 * que aparecen en ella.
	 * @return Lista con los elementos (clave) y su numero de apariciones (valor)
	 */
	private HashMap<String, Integer> elementosUnicosMatriz(){
		//Lista para identificar los elementos que tienen coincidencias
		HashMap<String,Integer> ocurrencias = new HashMap<String,Integer>();
		for( int f = 0; f < this.alto; f++){
			for( int c = 0; c < this.ancho; c++){
				ocurrencias.put(this.matriz[f][c], 0);
			}
		}
		
		//Recorrido de la matriz para contar las ocurrencias
		for (Map.Entry<String, Integer> valor : ocurrencias.entrySet()) {
			for (int f = 0; f < this.alto; f++) {
				for (int c = 0; c < this.ancho; c++) {
					if(valor.getKey().equals(this.matriz[f][c])) {
						ocurrencias.put(valor.getKey(), valor.getValue()+1);
					}
				}
			}
		}
		return ocurrencias;
	}

}
