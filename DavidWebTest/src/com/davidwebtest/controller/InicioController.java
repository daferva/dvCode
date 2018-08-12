package com.davidwebtest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.davidjpa.model.Log;
import com.davidjpa.test.TestLog;
import com.davidwebtest.model.Letras;
import com.davidwebtest.model.Matriz;
import com.davidwebtest.model.Numeros;

/**
 * 
 * @author DavidV
 *
 */
public class InicioController {
	
	private Matriz matriz;
	private int operacion;
	private Log log = new Log();
	
	public InicioController(String dim, String tipo, String cont, int ope, String usuario) {
		operacion = ope;
		String[] dimension= dim.split("-"); 
		if(tipo.equals("N")) {
			this.matriz = new Numeros(Integer.valueOf(dimension[0]), Integer.valueOf(dimension[1]), cont);
		}else {
			this.matriz = new Letras(Integer.valueOf(dimension[0]), Integer.valueOf(dimension[1]), cont);
		}
		
		log.setTramaIn("Dimension: " + dim + "; " +
					   "Tipo Matriz: " + tipo + "; "+
					   "Contenido: " + cont + "; " +
					   "Operacion: " +  String.valueOf(ope));
		log.setUsuario(usuario);
	}

	public String[][] ejecutarOperacion() {
		String[][] resultado = null;
		try {
		switch (operacion) {
		case 1://Consultar Ocurrencias
			HashMap<String, Integer> ocurrencias = this.matriz.consultarOcurrencias();
			resultado = new String[ocurrencias.size()][2];
			int i = 0;
			for (Map.Entry<String, Integer> reg : ocurrencias.entrySet()) {
				resultado[i][0] = reg.getKey();
				resultado[i][1] = reg.getValue().toString();
				i++;
			}
			break;
		case 2://Eliminar Repetidos
			resultado = this.matriz.eliminarRepetidos();
			break;
		case 3://Ordenar Ascendentemente
			resultado = this.matriz.ordenarAscendente();
			break;
		}
		
		completarLog(resultado);
		TestLog.insertarLog(log);
		}
		catch (Exception ex) {
			System.out.println("Error en la ejecución de la operación: " + ex.getMessage());
			resultado = new String[1][2];
			resultado[0][0] = "KO";
			resultado[0][1] = ex.getMessage();
		}
		return resultado;
	}
	
	private void completarLog(String[][] resultado) {
		String tramaOut = "";
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				tramaOut = tramaOut.concat(resultado[i][j]);
			}
			tramaOut = tramaOut.concat("-");
		}
		log.setTramaOut(tramaOut);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		log.setFecha(sdf.format(new Date()));
	}

}
