
package src.com.inflectra.spiratest.addons.junitextension.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="TestCase_AddLinkResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "testCaseAddLinkResult"
})
@XmlRootElement(name = "TestCase_AddLinkResponse")
public class TestCaseAddLinkResponse {

    @XmlElement(name = "TestCase_AddLinkResult")
    protected Integer testCaseAddLinkResult;

    /**
     * Gets the value of the testCaseAddLinkResult property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTestCaseAddLinkResult() {
        return testCaseAddLinkResult;
    }

    /**
     * Sets the value of the testCaseAddLinkResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTestCaseAddLinkResult(Integer value) {
        this.testCaseAddLinkResult = value;
    }

}
