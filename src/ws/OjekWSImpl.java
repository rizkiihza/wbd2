package ws;

import database.MySQLconnect;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import location.location;

import driver.driver;
import profile.profile;
import history.history;
import history.listhistory;


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
                String sql = "select id, Name, avg(rating) as rating_ratarata, count(ID_Cust) as voter , foto from profil, " +
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
                    dTemp.setFoto(result.getString("foto"));
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
                String sq = "select ID, Name, avg(rating) as rating_ratarata, count(ID_Cust) as voter, foto from profil, " +
                        "history where ID = \"" + rs.getInt("ID") + "\" and ID = ID_Driver";
                ResultSet r = s.executeQuery(sq);
                while (r.next()) {
                    dTemp.setID(r.getInt("ID"));
                    dTemp.setName(r.getString("Name"));
                    dTemp.setRate(r.getFloat("rating_ratarata"));
                    dTemp.setVoter(r.getInt("voter"));
                    dTemp.setStatus("Others Driver");
                    dTemp.setFoto(r.getString("foto"));
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
    public void editProfileData(String id, String Name, String Phone, String Driver){
        Connection conn = null;

        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();

            Statement stmt = conn.createStatement();

            String sql = "update profil set Name = \"" + Name + "\" where ID = " + id;
            stmt.executeUpdate(sql);

            sql = "update profil set Phone = \"" + Phone +"\" where ID = " + id;
            stmt.executeUpdate(sql);

            sql = "update profil set Driver = \"" + Driver +"\" where ID = " + id;
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
    public void insertHistory(int idCust, String source, String dest, String idDri, String date, int rating, String comment) {
        Connection conn = null;

        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();

            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO `history`(`ID_Cust`, `Source`, `Dest`, `ID_Driver`, `Order_Date`, `Rating`, " +
                    "`Comment`, `HidDriver`, `HidCust`) " +
                    "VALUES (2,\""+ source + "\",\""+ dest +"\",\""+ idDri + "\",\""+ date + "\"," +
                    "\""+ rating + "\",\"" + comment + "\",0,0)";
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
            String sql = "select ID, Name, Username, foto from profil where ID = " + id;

            ResultSet r = stmt.executeQuery(sql);
            while (r.next()) {
                d.setID(r.getInt("ID"));
                d.setName(r.getString("Name"));
                d.setRate(4);
                d.setVoter(1);
                d.setStatus(r.getString("Username"));
                d.setFoto(r.getString("foto"));
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

    @Override
    public String getDriverHistory(String id) {
        Connection conn = null;

         listhistory list = new listhistory();


        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM history JOIN profil ON history.ID_Cust = profil.ID WHERE ID_Driver = " + id;

            ResultSet r = stmt.executeQuery(sql);


            while (r.next()) {
                history h = new history();

                h.setID(String.valueOf(r.getInt("Order_Id")));
                System.out.println(h.getID());
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                h.setDate(df.format(r.getDate("Order_Date")).toString());
                System.out.println(h.getDate());
                h.setComment(r.getString("Comment"));
                System.out.println(h.getComment());
                h.setDest(r.getString("Dest"));
                h.setPick(r.getString("Source"));
                h.setHidden(r.getBoolean("HidCust"));

                h.setName(r.getString("Name"));
                h.setImg(r.getString("foto"));

                int cust_id = r.getInt("ID_Cust");
//
//                String sql2 = "SELECT * FROM profil WHERE ID = " + cust_id;
//
//                ResultSet result = stmt.executeQuery(sql2);
//
//                if (result.next()) {
//                    h.setName(result.getString("Name"));
//                    h.setImg(result.getString("foto"));
//                }

                list.getList().add(h);
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

        return list.toJson();
    }

    @Override
    public String getLocation(String  id) {
        location user = new location();
        Connection conn = null;

        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();

            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM pref_location WHERE ID = " + id;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                user.tempat.add(rs.getString("Location"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user.toJson();
    }

}
