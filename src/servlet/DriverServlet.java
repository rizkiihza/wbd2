package servlet;

import database.MySQLconnect;
import ws.OjekWS;
import ws.OjekWSImplService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "DriverServlet")
public class DriverServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        OjekWSImplService driverService = new OjekWSImplService();
        OjekWS eif = driverService.getPort(OjekWS.class);
        String driverResult = eif.getDriver(request.getParameter("picking-point"),
                request.getParameter("destination"), request.getParameter("pref-driver"));
        response.setContentType("text/xml");

        out.print(driverResult);
        out.flush();
//        Connection conn = null;
//        try {
//            MySQLconnect.connect();
//            conn = MySQLconnect.getConn();
//            Statement stmt = conn.createStatement();
//            String sql = "Select * from profil";
//
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                out.println("Nama : " + rs.getString("Name"));
//                out.println("Email : " + rs.getString("Email"));
//                out.println("Password : " + rs.getString("Password"));
//            }
//
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Your Code...
    }
}
