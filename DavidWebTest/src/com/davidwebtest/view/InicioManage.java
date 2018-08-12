/**
 * 
 */
package com.davidwebtest.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.davidjpa.model.Log;
import com.davidjpa.test.TestLog;
import com.davidwebtest.controller.InicioController;

/**
 * @author DavidV
 *
 */
@ManagedBean(name = "inicio")
@ViewScoped
public class InicioManage implements Serializable{

	private static final long serialVersionUID = -1109127461694429070L;
	private List<Log> listLog;
	private List<VOResultado> listaResultado = new ArrayList<VOResultado>();
	private String dimension;
	private String contenidoN;
	private String contenidoL;
	private String tipoMatriz;
	private int operacion;
	
	public InicioManage() {
		this.listLog = TestLog.getLog();
		System.out.println(this.listLog.size());
	}

	public List<VOResultado> getListaResultado() {
		return listaResultado;
	}

	public void setListaResultado(List<VOResultado> listaResultado) {
		this.listaResultado = listaResultado;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getContenidoN() {
		return contenidoN;
	}

	public void setContenidoN(String contenidoN) {
		this.contenidoN = contenidoN;
	}

	public String getContenidoL() {
		return contenidoL;
	}

	public void setContenidoL(String contenidoL) {
		this.contenidoL = contenidoL;
	}

	public String getTipoMatriz() {
		return tipoMatriz;
	}

	public void setTipoMatriz(String tipoMatriz) {
		this.tipoMatriz = tipoMatriz;
	}

	public int getOperacion() {
		return operacion;
	}

	public void setOperacion(int operacion) {
		this.operacion = operacion;
	}

	public List<Log> getListLog() {
		return listLog;
	}

	public void setListLog(List<Log> listLog) {
		this.listLog = listLog;
	}
	
	public void buttonAction(ActionEvent actionEvent) {
		
		String usuario = "dvasco"; //supongamos que tomanos el usuario del context0
        InicioController control = new InicioController(dimension, tipoMatriz, tipoMatriz.equals("N")? contenidoN:contenidoL, operacion, usuario);
        
        String[][] resultado = control.ejecutarOperacion();
        if(!resultado[0][0].equals("KO")) {
        	llenarResultado(operacion, resultado);
        	addMessage("Solicitu procesada.");
        }else {
        	addMessage("Ocurrió un error procesando la solicitud: " + resultado[0][1]);
        }
    }
     
	/**
	 * Estructura el resultado para ser mostrado en la vista
	 * @param ope
	 * @param resultado
	 */
    private void llenarResultado(int ope, String[][] resultado) {
    	
		if(ope==1) {
			for (int f = 0; f < resultado.length; f++) {
				listaResultado.add(new VOResultado(f,resultado[f][0]+"("+resultado[f][1]+")"));
			}
		}else {
			String linea = "";
			for (int f = 0; f < resultado.length; f++) {
				for (int c = 0; c < resultado[f].length; c++) {
					linea = linea.concat(resultado[f][c]);
				}
				listaResultado.add(new VOResultado(f, linea));
				linea="";
			}
		}
	}

	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
