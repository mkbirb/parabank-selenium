
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
 *         &lt;element name="Release_RetrieveCommentsResult" type="{http://schemas.datacontract.org/2004/07/Inflectra.SpiraTest.Web.Services.v3_0.DataObjects}ArrayOfRemoteComment" minOccurs="0"/>
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
    "releaseRetrieveCommentsResult"
})
@XmlRootElement(name = "Release_RetrieveCommentsResponse")
public class ReleaseRetrieveCommentsResponse {

    @XmlElementRef(name = "Release_RetrieveCommentsResult", namespace = "http://www.inflectra.com/SpiraTest/Services/v3.0/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfRemoteComment> releaseRetrieveCommentsResult;

    /**
     * Gets the value of the releaseRetrieveCommentsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRemoteComment }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRemoteComment> getReleaseRetrieveCommentsResult() {
        return releaseRetrieveCommentsResult;
    }

    /**
     * Sets the value of the releaseRetrieveCommentsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRemoteComment }{@code >}
     *     
     */
    public void setReleaseRetrieveCommentsResult(JAXBElement<ArrayOfRemoteComment> value) {
        this.releaseRetrieveCommentsResult = ((JAXBElement<ArrayOfRemoteComment> ) value);
    }

}
