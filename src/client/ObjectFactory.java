
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindAllDriversResponse_QNAME = new QName("http://ws/", "findAllDriversResponse");
    private final static QName _FindDriver_QNAME = new QName("http://ws/", "findDriver");
    private final static QName _FindAllDrivers_QNAME = new QName("http://ws/", "findAllDrivers");
    private final static QName _FindDriverResponse_QNAME = new QName("http://ws/", "findDriverResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAllDriversResponse }
     * 
     */
    public FindAllDriversResponse createFindAllDriversResponse() {
        return new FindAllDriversResponse();
    }

    /**
     * Create an instance of {@link FindDriver }
     * 
     */
    public FindDriver createFindDriver() {
        return new FindDriver();
    }

    /**
     * Create an instance of {@link FindAllDrivers }
     * 
     */
    public FindAllDrivers createFindAllDrivers() {
        return new FindAllDrivers();
    }

    /**
     * Create an instance of {@link FindDriverResponse }
     * 
     */
    public FindDriverResponse createFindDriverResponse() {
        return new FindDriverResponse();
    }

    /**
     * Create an instance of {@link Driver }
     * 
     */
    public Driver createDriver() {
        return new Driver();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllDriversResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findAllDriversResponse")
    public JAXBElement<FindAllDriversResponse> createFindAllDriversResponse(FindAllDriversResponse value) {
        return new JAXBElement<FindAllDriversResponse>(_FindAllDriversResponse_QNAME, FindAllDriversResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDriver }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findDriver")
    public JAXBElement<FindDriver> createFindDriver(FindDriver value) {
        return new JAXBElement<FindDriver>(_FindDriver_QNAME, FindDriver.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllDrivers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findAllDrivers")
    public JAXBElement<FindAllDrivers> createFindAllDrivers(FindAllDrivers value) {
        return new JAXBElement<FindAllDrivers>(_FindAllDrivers_QNAME, FindAllDrivers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDriverResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findDriverResponse")
    public JAXBElement<FindDriverResponse> createFindDriverResponse(FindDriverResponse value) {
        return new JAXBElement<FindDriverResponse>(_FindDriverResponse_QNAME, FindDriverResponse.class, null, value);
    }

}
