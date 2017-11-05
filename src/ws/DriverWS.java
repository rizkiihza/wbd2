package ws;

import beans.Driver;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DriverWS {
    @WebMethod
    public Driver findDriver();

    @WebMethod
    public List<Driver> findAllDrivers();
}
