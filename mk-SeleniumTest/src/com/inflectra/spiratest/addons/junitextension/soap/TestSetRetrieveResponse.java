
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
 *         &lt;element name="TestSet_RetrieveResult" type="{http://schemas.datacontract.org/2004/07/Inflectra.SpiraTest.Web.Services.v3_0.DataObjects}ArrayOfRemoteTestSet" minOccurs="0"/>
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
    "testSetRetrieveResult"
})
@XmlRootElement(name = "TestSet_RetrieveResponse")
public class TestSetRetrieveResponse {

    @XmlElementRef(name = "TestSet_RetrieveResult", namespace = "http://www.inflectra.com/SpiraTest/Services/v3.0/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfRemoteTestSet> testSetRetrieveResult;

    /**
     * Gets the value of the testSetRetrieveResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRemoteTestSet }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRemoteTestSet> getTestSetRetrieveResult() {
        return testSetRetrieveResult;
    }

    /**
     * Sets the value of the testSetRetrieveResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRemoteTestSet }{@code >}
     *     
     */
    public void setTestSetRetrieveResult(JAXBElement<ArrayOfRemoteTestSet> value) {
        this.testSetRetrieveResult = ((JAXBElement<ArrayOfRemoteTestSet> ) value);
    }

}
