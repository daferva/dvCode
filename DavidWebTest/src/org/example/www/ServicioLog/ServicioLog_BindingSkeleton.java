/**
 * ServicioLog_BindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.ServicioLog;

public class ServicioLog_BindingSkeleton implements org.example.www.ServicioLog.ServicioLog_PortType, org.apache.axis.wsdl.Skeleton {
    private org.example.www.ServicioLog.ServicioLog_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.example.org/ServicioLog/", "ConsultaLogRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.example.org/ServicioLog/", ">ConsultaLogRequest"), org.example.www.ServicioLog.ConsultaLogRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("consultaLog", _params, new javax.xml.namespace.QName("http://www.example.org/ServicioLog/", "ConsultaLogResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.example.org/ServicioLog/", ">ConsultaLogResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "ConsultaLog"));
        _oper.setSoapAction("http://www.example.org/ServicioLog/ConsultaLog");
        _myOperationsList.add(_oper);
        if (_myOperations.get("consultaLog") == null) {
            _myOperations.put("consultaLog", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("consultaLog")).add(_oper);
    }

    public ServicioLog_BindingSkeleton() {
        this.impl = new org.example.www.ServicioLog.ServicioLog_BindingImpl();
    }

    public ServicioLog_BindingSkeleton(org.example.www.ServicioLog.ServicioLog_PortType impl) {
        this.impl = impl;
    }
    public org.example.www.ServicioLog.ConsultaLogResponseRegistrosLog[] consultaLog(org.example.www.ServicioLog.ConsultaLogRequest parameters) throws java.rmi.RemoteException
    {
        org.example.www.ServicioLog.ConsultaLogResponseRegistrosLog[] ret = impl.consultaLog(parameters);
        return ret;
    }

}
