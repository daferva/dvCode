/**
 * ServicioLog_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.ServicioLog;

public class ServicioLog_ServiceLocator extends org.apache.axis.client.Service implements org.example.www.ServicioLog.ServicioLog_Service {

    public ServicioLog_ServiceLocator() {
    }


    public ServicioLog_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioLog_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioLog
    private java.lang.String ServicioLog_address = "http://localhost:8080/DavidWebTest/services/ServicioLog";

    public java.lang.String getServicioLogAddress() {
        return ServicioLog_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioLogWSDDServiceName = "ServicioLog";

    public java.lang.String getServicioLogWSDDServiceName() {
        return ServicioLogWSDDServiceName;
    }

    public void setServicioLogWSDDServiceName(java.lang.String name) {
        ServicioLogWSDDServiceName = name;
    }

    public org.example.www.ServicioLog.ServicioLog_PortType getServicioLog() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioLog_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioLog(endpoint);
    }

    public org.example.www.ServicioLog.ServicioLog_PortType getServicioLog(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.example.www.ServicioLog.ServicioLog_BindingStub _stub = new org.example.www.ServicioLog.ServicioLog_BindingStub(portAddress, this);
            _stub.setPortName(getServicioLogWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioLogEndpointAddress(java.lang.String address) {
        ServicioLog_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.example.www.ServicioLog.ServicioLog_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.example.www.ServicioLog.ServicioLog_BindingStub _stub = new org.example.www.ServicioLog.ServicioLog_BindingStub(new java.net.URL(ServicioLog_address), this);
                _stub.setPortName(getServicioLogWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioLog".equals(inputPortName)) {
            return getServicioLog();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.example.org/ServicioLog/", "ServicioLog");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.example.org/ServicioLog/", "ServicioLog"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioLog".equals(portName)) {
            setServicioLogEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
