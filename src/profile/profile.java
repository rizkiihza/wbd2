package profile;

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
public class profile extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        //set Response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "profile";
        out.println("PROFILE");
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
            String sql = "Select * from driver where id = " + request.getParameter("id");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                out.println("id : " + rs.getInt("id") + "<br>");
                out.println("nama_driver : " + rs.getString("nama_driver") + "<br>");
                out.println("voter : " + rs.getString("voter") + "<br>");
                out.println("rating_ratarata : " + rs.getString("rating_ratarata") + "<br>");
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
