package profile;

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

public class editProfile {
    @WebServlet(name = "DriverServlet")
    public class ProfileServlet extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //set Response content type
            OjekWSImplService service = new OjekWSImplService();
            OjekWS eif = service.getPort(OjekWS.class);

            String ID = request.getParameter("ID");
            String Name = request.getParameter("Name");
            String Phone = request.getParameter("Phone");
            String Foto = request.getParameter("Foto");

            eif.editProfileData(ID,Name,Phone,Foto);
            
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Your Code...
        }
    }
}
