package profile;

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
public class ProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        //set Response content type
        PrintWriter out = response.getWriter();
        OjekWSImplService service = new OjekWSImplService();
        OjekWS eif = service.getPort(OjekWS.class);
        String Result = eif.getProfileData(request.getParameter("ID"));
        response.setContentType("text/xml");

        out.print(Result);
        out.flush();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Your Code...
    }
}
