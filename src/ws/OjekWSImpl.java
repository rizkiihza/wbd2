package ws;

import database.MySQLconnect;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebService(endpointInterface = "ws.OjekWS")
public class OjekWSImpl implements OjekWS {

    @Override
    public String getDriver(String pick, String dest, String prefDriver) {
        String xml = "";

        Connection conn = null;

        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();

            xml += "<?xml version='1.0' encoding='utf-8'?>\n";
            xml += "<sales xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns='http://java.sun.com/xml/ns/javaee' xsi:schemaLocation='http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd'>\n";

            if (!prefDriver.equals("")) {
                Statement state = conn.createStatement();
                String sql = "Select * from profil join driver WHERE profil.ID = driver.ID and profil.Name = \"" + prefDriver + "\"";

                ResultSet result = state.executeQuery(sql);
//                if (result.wasNull()) {
//                    out.println("No Drivers Founded");
//                } else {
                while (result.next()) {
                    xml += "<prefDriver>\n";
                    xml += "<driverName>" + result.getString("Name") + "</driverName>\n";
                    xml += "<driverRate>" + result.getString("rating_ratarata") + "</driverRate>\n";
                    xml += "<voter>" + result.getString("voter") + "</voter>\n";
                    xml += "</prefDriver>\n";
                }
//                }

                result.close();
                state.close();
            }

            Statement stmt = conn.createStatement();

            String sql = "Select DISTINCT driver.ID, Name, voter, rating_ratarata from profil natural join driver " +
                    "natural join pref_location WHERE Location = \"" + pick + "\" or " + "Location = \"" +
                    dest + "\"";
            ResultSet rs = stmt.executeQuery(sql);

//            if (rs.wasNull()) {
//                out.println("No Drivers Founded");
//            } else {
            while (rs.next()) {
                xml += "<othersDriver-" + rs.getInt("driver.ID") + ">\n";
                xml += "<driverName>" + rs.getString("Name") + "</driverName>\n";
                xml += "<driverRate>" + rs.getString("rating_ratarata") + "</driverRate>\n";
                xml += "<voter>" + rs.getString("voter") + "</voter>\n";
                xml += "</othersDriver-" + rs.getInt("driver.ID") + ">\n";
            }
//            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return xml;
    }

    @Override
    public String getProfileData(String id) {
        String xml = "";

        Connection conn = null;

        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();

            xml += "<?xml version='1.0' encoding='utf-8'?>\n";
            xml += "<sales xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns='http://java.sun.com/xml/ns/javaee' xsi:schemaLocation='http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd'>\n";



            Statement stmt = conn.createStatement();

            String sql = "Select * from profil where id = " + id;
            ResultSet rs = stmt.executeQuery(sql);

//            if (rs.wasNull()) {
//                out.println("No Drivers Founded");
//            } else {
            while (rs.next()) {
                xml += "<othersDriver-" + rs.getInt("ID") + ">\n";
                xml += "<driverName>" + rs.getString("Name") + "</driverName>\n";
                xml += "<driverRate>" + rs.getString("Username") + "</driverRate>\n";
                xml += "<voter>" + rs.getString("Email") + "</voter>\n";
                xml += "</othersDriver-" + rs.getInt("Phone") + ">\n";
                xml += "<voter>" + rs.getString("Email") + "</voter>\n";
            }
//            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return xml;
    }
}
