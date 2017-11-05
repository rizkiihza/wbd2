package ws;

import beans.Driver;
import dao.DriverDAO;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ws.DriverWS")
public class DriverWSImpl implements DriverWS {
    private DriverDAO d = new DriverDAO();
    @Override
    public Driver findDriver() {
        return this.d.find();
    }

    @Override
    public List<Driver> findAllDrivers() {
        return this.d.findAll();
    }
}
