
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
 *         &lt;element name="TestCase_RetrieveByTestSetIdResult" type="{http://schemas.datacontract.org/2004/07/Inflectra.SpiraTest.Web.Services.v3_0.DataObjects}ArrayOfRemoteTestCase" minOccurs="0"/>
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
    "testCaseRetrieveByTestSetIdResult"
})
@XmlRootElement(name = "TestCase_RetrieveByTestSetIdResponse")
public class TestCaseRetrieveByTestSetIdResponse {

    @XmlElementRef(name = "TestCase_RetrieveByTestSetIdResult", namespace = "http://www.inflectra.com/SpiraTest/Services/v3.0/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfRemoteTestCase> testCaseRetrieveByTestSetIdResult;

    /**
     * Gets the value of the testCaseRetrieveByTestSetIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRemoteTestCase }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRemoteTestCase> getTestCaseRetrieveByTestSetIdResult() {
        return testCaseRetrieveByTestSetIdResult;
    }

    /**
     * Sets the value of the testCaseRetrieveByTestSetIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRemoteTestCase }{@code >}
     *     
     */
    public void setTestCaseRetrieveByTestSetIdResult(JAXBElement<ArrayOfRemoteTestCase> value) {
        this.testCaseRetrieveByTestSetIdResult = ((JAXBElement<ArrayOfRemoteTestCase> ) value);
    }

}
