
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
 *         &lt;element name="Requirement_RetrieveForOwnerResult" type="{http://schemas.datacontract.org/2004/07/Inflectra.SpiraTest.Web.Services.v3_0.DataObjects}ArrayOfRemoteRequirement" minOccurs="0"/>
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
    "requirementRetrieveForOwnerResult"
})
@XmlRootElement(name = "Requirement_RetrieveForOwnerResponse")
public class RequirementRetrieveForOwnerResponse {

    @XmlElementRef(name = "Requirement_RetrieveForOwnerResult", namespace = "http://www.inflectra.com/SpiraTest/Services/v3.0/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfRemoteRequirement> requirementRetrieveForOwnerResult;

    /**
     * Gets the value of the requirementRetrieveForOwnerResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRemoteRequirement }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRemoteRequirement> getRequirementRetrieveForOwnerResult() {
        return requirementRetrieveForOwnerResult;
    }

    /**
     * Sets the value of the requirementRetrieveForOwnerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRemoteRequirement }{@code >}
     *     
     */
    public void setRequirementRetrieveForOwnerResult(JAXBElement<ArrayOfRemoteRequirement> value) {
        this.requirementRetrieveForOwnerResult = ((JAXBElement<ArrayOfRemoteRequirement> ) value);
    }

}
