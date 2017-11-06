
package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OjekWS", targetNamespace = "http://ws/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface OjekWS {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://ws/OjekWS/getDriverRequest", output = "http://ws/OjekWS/getDriverResponse")
    public String getDriver(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://ws/OjekWS/getProfileDataRequest", output = "http://ws/OjekWS/getProfileDataResponse")
    public String getProfileData(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    @WebMethod
    public void editProfileData(
            @WebParam(name = "arg0", partName = "arg0")
                    String arg0,
            @WebParam(name = "arg1", partName = "arg1")
                    String arg1,
            @WebParam(name = "arg2", partName = "arg2")
                    String arg2,
            @WebParam(name = "arg3", partName = "arg3")
                    String arg3
    );

}
