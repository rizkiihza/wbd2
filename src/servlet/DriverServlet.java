package servlet;

import database.MySQLconnect;

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
        Connection conn = null;
        //set Response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Select Driver";

//        String docType = "<!doctype html public \\\"-//w3c//dtd html 4.0 \" + \"transitional//en\\\">\\n";

        out.println(
            "<html>" +
                "<head><title>" + title + "</title></head>" +
                "<body>"
        );
        try {
            MySQLconnect.connect();
            conn = MySQLconnect.getConn();
            Statement stmt = conn.createStatement();
            String sql = "Select * from driver , lokasi WHERE driver.id = lokasi.id";

            ResultSet rs = stmt.executeQuery(sql);

            if (!request.getParameter("pref-driver").isEmpty()) {
                out.println("Preferred Driver : <br>");
                while (rs.next()) {
                    String name = rs.getString("nama_driver");
                    if (name.equals(request.getParameter("pref-driver"))) {
                        out.println("ID : " + rs.getInt("id") + "<br>");
                        out.println("Driver Name : " + name + "<br>");
                        out.println("Location : " + rs.getString("pref_location") + "<br> <br>");
                    }
                }
            }

            String picking_point = request.getParameter("picking-point");
            String dest = request.getParameter("destination");
            rs = stmt.executeQuery(sql);
            out.println("Other Driver : <br>");
            while (rs.next()) {
                String loc = rs.getString("pref_location");
                if (loc.equals(picking_point) || loc.equals(dest)) {
                    out.println("ID : " + rs.getInt("id") + "<br>");
                    out.println("Driver Name : " + rs.getString("nama_driver") + "<br>");
                    out.println("Location : " + loc + "<br> <br>");
                }
            }

            out.println("</body></html>");

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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Your Code...
    }
}
