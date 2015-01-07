/**
 * EnterpriseAuthenticationServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yesway.webnotify.soap.enterpriseauthenticationservice;

public class EnterpriseAuthenticationServiceLocator extends org.apache.axis.client.Service implements com.yesway.webnotify.soap.enterpriseauthenticationservice.EnterpriseAuthenticationService {

    public EnterpriseAuthenticationServiceLocator() {
    }


    public EnterpriseAuthenticationServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EnterpriseAuthenticationServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IEnterpriseAuthenticationService
    private java.lang.String BasicHttpBinding_IEnterpriseAuthenticationService_address = "http://10.1.11.101:5678/EnterpriseAuthenticationService.svc";

    public java.lang.String getBasicHttpBinding_IEnterpriseAuthenticationServiceAddress() {
        return BasicHttpBinding_IEnterpriseAuthenticationService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IEnterpriseAuthenticationServiceWSDDServiceName = "BasicHttpBinding_IEnterpriseAuthenticationService";

    public java.lang.String getBasicHttpBinding_IEnterpriseAuthenticationServiceWSDDServiceName() {
        return BasicHttpBinding_IEnterpriseAuthenticationServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IEnterpriseAuthenticationServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IEnterpriseAuthenticationServiceWSDDServiceName = name;
    }

    public com.yesway.webnotify.soap.enterpriseauthenticationservice.IEnterpriseAuthenticationService getBasicHttpBinding_IEnterpriseAuthenticationService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IEnterpriseAuthenticationService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IEnterpriseAuthenticationService(endpoint);
    }

    public com.yesway.webnotify.soap.enterpriseauthenticationservice.IEnterpriseAuthenticationService getBasicHttpBinding_IEnterpriseAuthenticationService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.yesway.webnotify.soap.enterpriseauthenticationservice.BasicHttpBinding_IEnterpriseAuthenticationServiceStub _stub = new com.yesway.webnotify.soap.enterpriseauthenticationservice.BasicHttpBinding_IEnterpriseAuthenticationServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IEnterpriseAuthenticationServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IEnterpriseAuthenticationServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IEnterpriseAuthenticationService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.yesway.webnotify.soap.enterpriseauthenticationservice.IEnterpriseAuthenticationService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.yesway.webnotify.soap.enterpriseauthenticationservice.BasicHttpBinding_IEnterpriseAuthenticationServiceStub _stub = new com.yesway.webnotify.soap.enterpriseauthenticationservice.BasicHttpBinding_IEnterpriseAuthenticationServiceStub(new java.net.URL(BasicHttpBinding_IEnterpriseAuthenticationService_address), this);
                _stub.setPortName(getBasicHttpBinding_IEnterpriseAuthenticationServiceWSDDServiceName());
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
        if ("BasicHttpBinding_IEnterpriseAuthenticationService".equals(inputPortName)) {
            return getBasicHttpBinding_IEnterpriseAuthenticationService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "EnterpriseAuthenticationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IEnterpriseAuthenticationService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IEnterpriseAuthenticationService".equals(portName)) {
            setBasicHttpBinding_IEnterpriseAuthenticationServiceEndpointAddress(address);
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
