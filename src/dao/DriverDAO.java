package dao;

import beans.*;
import java.util.*;

public class DriverDAO {

    public Driver find() {
        return new Driver("1", "ITB");
    }

    public List<Driver> findAll() {
        List<Driver> result = new ArrayList<>();
//
        result.add(new Driver("1", "ITB"));
        result.add(new Driver("1", "UNPAD"));
        result.add(new Driver("1", "Borromeus"));
//
        return result;
    }
}
