
package src.com.inflectra.spiratest.addons.junitextension.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Incident_RetrieveNewResult" type="{http://schemas.datacontract.org/2004/07/Inflectra.SpiraTest.Web.Services.v3_0.DataObjects}ArrayOfRemoteIncident" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "incidentRetrieveNewResult"
})
@XmlRootElement(name = "Incident_RetrieveNewResponse")
public class IncidentRetrieveNewResponse {

    @XmlElementRef(name = "Incident_RetrieveNewResult", namespace = "http://www.inflectra.com/SpiraTest/Services/v3.0/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfRemoteIncident> incidentRetrieveNewResult;

    /**
     * Gets the value of the incidentRetrieveNewResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRemoteIncident }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRemoteIncident> getIncidentRetrieveNewResult() {
        return incidentRetrieveNewResult;
    }

    /**
     * Sets the value of the incidentRetrieveNewResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRemoteIncident }{@code >}
     *     
     */
    public void setIncidentRetrieveNewResult(JAXBElement<ArrayOfRemoteIncident> value) {
        this.incidentRetrieveNewResult = ((JAXBElement<ArrayOfRemoteIncident> ) value);
    }

}
