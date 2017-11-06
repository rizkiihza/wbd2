package ws;

import database.MySQLconnect;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import profile.profile;

@WebService(endpointInterface = "ws.OjekWS")
public class OjekWSImpl implements OjekWS {

    @Override
    public String getDriver(String pick, String dest, String prefDriver) {
        String xml = "";
        Connection conn = null;

        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();


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
        profile user = new profile();
        Connection conn = null;

        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();

            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM profil WHERE ID = " + id;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                user.ID = rs.getString("ID");
                user.Name = rs.getString("Name");
                user.Username = rs.getString("Username");
                user.Email = rs.getString("Email");
                user.Phone = rs.getString("Phone");
                user.Driver = rs.getString("Driver");
                user.Foto = rs.getString("Foto");
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

        return user.toJson();
    }

    @Override
    public void editProfileData(String id, String Name, String Phone, String Foto){
        Connection conn = null;

        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();

            Statement stmt = conn.createStatement();

            String sql = "update profil set Name = " + Name + " where ID = " + id;
            stmt.executeQuery(sql);

            sql = "update profil set Phone = " + Phone +" where ID = " + id;
            stmt.executeQuery(sql);

            sql = "update Foto set Foto = " + Foto + " where ID = " + id;
            stmt.executeQuery(sql);

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
    }
}
