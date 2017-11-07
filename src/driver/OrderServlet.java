package driver;

import ws.OjekWS;
import ws.OjekWSImplService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //your Code
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        OjekWSImplService driverService = new OjekWSImplService();
        OjekWS eif = driverService.getPort(OjekWS.class);
        driver d = new driver();
        String res = eif.getDriverWith(id);

        d.fromJson(res);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

//        out.print(res);

        out.println(d.getID()+ "<br>");
        out.println("@" + d.getStatus() + "<br>");
        out.println(d.getName() + "<br>");
    }
}
