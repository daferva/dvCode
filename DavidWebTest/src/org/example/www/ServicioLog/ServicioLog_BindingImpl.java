/**
 * ServicioLog_BindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.ServicioLog;

import java.util.List;

import com.davidjpa.model.Log;
import com.davidjpa.test.TestLog;

public class ServicioLog_BindingImpl implements org.example.www.ServicioLog.ServicioLog_PortType{
	
    public org.example.www.ServicioLog.ConsultaLogResponseRegistrosLog[] consultaLog(org.example.www.ServicioLog.ConsultaLogRequest parameters) throws java.rmi.RemoteException {
    	
    	List<Log> listLog = TestLog.getLog();
    	ConsultaLogResponseRegistrosLog[] respuesta = new ConsultaLogResponseRegistrosLog[listLog.size()];
    	int i=0;
    	for (Log req : listLog) {
    		respuesta[i] = new ConsultaLogResponseRegistrosLog(new InfoLog(String.valueOf(req.getId()), req.getTramaIn(), req.getTramaIn(), req.getFecha(), req.getUsuario()));
    		i++;
		}
    	return respuesta;
    }

}
