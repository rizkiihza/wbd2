package ws;

import database.MySQLconnect;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import driver.driver;
import profile.profile;

@WebService(endpointInterface = "ws.OjekWS")
public class OjekWSImpl implements OjekWS {

    @Override
    public StringArray getDriver(String pick, String dest, String prefDriver) {
        ArrayList<String> list = new ArrayList<>();
        driver dTemp = new driver();
        Connection conn = null;

        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();

            if (!prefDriver.equals("")) {
                Statement state = conn.createStatement();
                String sql = "select id, Name, avg(rating) as rating_ratarata, count(ID_Cust) as voter from profil, " +
                        "history where Name = \"" + prefDriver + "\"  and ID = ID_Driver";

                ResultSet result = state.executeQuery(sql);
//                if (result.wasNull()) {
//                    out.println("No Drivers Founded");
//                } else {
                while (result.next()) {
                    dTemp.setID(result.getInt("ID"));
                    dTemp.setName(result.getString("Name"));
                    dTemp.setRate(result.getFloat("rating_ratarata"));
                    dTemp.setVoter(result.getInt("voter"));
                    dTemp.setStatus("Preferred Driver");
                    list.add(dTemp.toJson());
                }
//                }

                result.close();
                state.close();
            }

            Statement stmt = conn.createStatement();

            String sql = "select distinct profil.ID as ID, Name from profil, pref_Location where profil.ID = " +
                    "pref_Location.ID and Location = \"" + pick + "\" or Location = \"" + dest + "\"";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Statement s = conn.createStatement();
                String sq = "select ID, Name, avg(rating) as rating_ratarata, count(ID_Cust) as voter from profil, " +
                        "history where ID = \"" + rs.getInt("ID") + "\" and ID = ID_Driver";
                ResultSet r = s.executeQuery(sq);
                while (r.next()) {
                    dTemp.setID(r.getInt("ID"));
                    dTemp.setName(r.getString("Name"));
                    dTemp.setRate(r.getFloat("rating_ratarata"));
                    dTemp.setVoter(r.getInt("voter"));
                    dTemp.setStatus("Others Driver");
                    list.add(dTemp.toJson());
                }

                r.close();
                s.close();
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

        StringArray res = new StringArray();

        //res.setItem(list);

        return res;
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

            if (user.Driver.equals("1")) {

                sql ="select avg(rating) as AvgRating from history where ID_DRIVER = " + id;
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    user.AvgRating = rs.getString("AvgRating");
                }

                sql ="select count(ID_Cust) as Vote from history where ID_DRIVER = " + id;
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    user.Vote = rs.getString("Vote");
                }

                sql = "select * from pref_location where ID =" + id;
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    user.Locations.add(rs.getString("Location"));
                }
            } else {
                user.AvgRating = "";
                user.Vote = "";
            }


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

            String sql = "update profil set Name = \"" + Name + "\" where ID = " + id;
            stmt.executeUpdate(sql);

            sql = "update profil set Phone = \"" + Phone +"\" where ID = " + id;
            stmt.executeUpdate(sql);

            sql = "update profil set Foto = \"" + Foto + "\" where ID = " + id;
            stmt.executeUpdate(sql);

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

    @Override
    public String getDriverWith(String id) {
        Connection conn = null;
        driver d = new driver();
        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();
            Statement stmt = conn.createStatement();
            String sql = "select ID, Name, Username from profil where ID = " + id;

            ResultSet r = stmt.executeQuery(sql);
            while (r.next()) {
                d.setID(r.getInt("ID"));
                d.setName(r.getString("Name"));
                d.setRate(4);
                d.setVoter(1);
                d.setStatus(r.getString("Username"));
            }

            r.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn == null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return d.toJson();
    }
}
