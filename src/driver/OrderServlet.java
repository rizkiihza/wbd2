package driver;

import ws.OjekWS;
import ws.OjekWSImplService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        OjekWSImplService driverService = new OjekWSImplService();
        OjekWS eif = driverService.getPort(OjekWS.class);

        Date date = new Date();
        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd");
        String pick = (String) session.getAttribute("pickPoint");
        String dest = (String) session.getAttribute("dest");
        String id = (String) session.getAttribute("idDriver");
        String today = fdate.format(date);
        int rate = Integer.valueOf(request.getParameter("rate"));

        eif.insertHistory(2, pick, dest, id, today, rate,
                request.getParameter("comment"));
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
