
package ec.edu.espe_matriz.wsClient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSEnvioMail", targetNamespace = "http://ws.espe_innovativa.edu.ec/", wsdlLocation = "http://10.1.0.25:8080/WS_EnvioMail-1.0-SNAPSHOT/WSEnvioMail?wsdl")
public class WSEnvioMail_Service
    extends Service
{

    private final static URL WSENVIOMAIL_WSDL_LOCATION;
    private final static WebServiceException WSENVIOMAIL_EXCEPTION;
    private final static QName WSENVIOMAIL_QNAME = new QName("http://ws.espe_innovativa.edu.ec/", "WSEnvioMail");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://10.1.0.25:8080/WS_EnvioMail-1.0-SNAPSHOT/WSEnvioMail?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSENVIOMAIL_WSDL_LOCATION = url;
        WSENVIOMAIL_EXCEPTION = e;
    }

    public WSEnvioMail_Service() {
        super(__getWsdlLocation(), WSENVIOMAIL_QNAME);
    }

    public WSEnvioMail_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSENVIOMAIL_QNAME, features);
    }

    public WSEnvioMail_Service(URL wsdlLocation) {
        super(wsdlLocation, WSENVIOMAIL_QNAME);
    }

    public WSEnvioMail_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSENVIOMAIL_QNAME, features);
    }

    public WSEnvioMail_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSEnvioMail_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSEnvioMail
     */
    @WebEndpoint(name = "WSEnvioMailPort")
    public WSEnvioMail getWSEnvioMailPort() {
        return super.getPort(new QName("http://ws.espe_innovativa.edu.ec/", "WSEnvioMailPort"), WSEnvioMail.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSEnvioMail
     */
    @WebEndpoint(name = "WSEnvioMailPort")
    public WSEnvioMail getWSEnvioMailPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.espe_innovativa.edu.ec/", "WSEnvioMailPort"), WSEnvioMail.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSENVIOMAIL_EXCEPTION!= null) {
            throw WSENVIOMAIL_EXCEPTION;
        }
        return WSENVIOMAIL_WSDL_LOCATION;
    }

}