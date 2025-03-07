
package src.com.inflectra.spiratest.addons.junitextension.soap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ImportExport", targetNamespace = "http://www.inflectra.com/SpiraTest/Services/v3.0/", wsdlLocation = "http://localhost/SpiraTeam/Services/v3_0/ImportExport.svc?WSDL")
public class ImportExport
    extends Service
{

    private final static URL IMPORTEXPORT_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.inflectra.spiratest.addons.junitextension.soap.ImportExport.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.inflectra.spiratest.addons.junitextension.soap.ImportExport.class.getResource(".");
            url = new URL(baseUrl, "http://localhost/SpiraTeam/Services/v3_0/ImportExport.svc?WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost/SpiraTeam/Services/v3_0/ImportExport.svc?WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        IMPORTEXPORT_WSDL_LOCATION = url;
    }

    public ImportExport(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ImportExport() {
        super(IMPORTEXPORT_WSDL_LOCATION, new QName("http://www.inflectra.com/SpiraTest/Services/v3.0/", "ImportExport"));
    }

    /**
     * 
     * @return
     *     returns IImportExport
     */
    @WebEndpoint(name = "BasicHttpBinding_IImportExport")
    public IImportExport getBasicHttpBindingIImportExport() {
        return super.getPort(new QName("http://www.inflectra.com/SpiraTest/Services/v3.0/", "BasicHttpBinding_IImportExport"), IImportExport.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IImportExport
     */
    @WebEndpoint(name = "BasicHttpBinding_IImportExport")
    public IImportExport getBasicHttpBindingIImportExport(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.inflectra.com/SpiraTest/Services/v3.0/", "BasicHttpBinding_IImportExport"), IImportExport.class, features);
    }

    /**
     * 
     * @return
     *     returns IImportExport
     */
    @WebEndpoint(name = "BasicHttpBinding_IImportExport1")
    public IImportExport getBasicHttpBindingIImportExport1() {
        return super.getPort(new QName("http://www.inflectra.com/SpiraTest/Services/v3.0/", "BasicHttpBinding_IImportExport1"), IImportExport.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IImportExport
     */
    @WebEndpoint(name = "BasicHttpBinding_IImportExport1")
    public IImportExport getBasicHttpBindingIImportExport1(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.inflectra.com/SpiraTest/Services/v3.0/", "BasicHttpBinding_IImportExport1"), IImportExport.class, features);
    }

}
