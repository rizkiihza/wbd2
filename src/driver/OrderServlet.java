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
        String idCust = (String) session.getAttribute("IDUserAktif");
        String idDriver = (String) session.getAttribute("idDriver");
        String today = fdate.format(date);
        int rate = Integer.valueOf(request.getParameter("rate"));

        eif.insertHistory(idCust, pick, dest, idDriver, today, rate,
                request.getParameter("comment"));

        String url = request.getContextPath() + "/profile.jsp";
        response.sendRedirect(url);
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

        out.print("<p class=\"title-complete-order\">HOW WAS IT?</p>");
        out.print("<center> <img id=\"img\"class=\"img-profile\" alt=\""+ d.getName() + "\" " +
                "src=\"" + d.getFoto() + "\"> </center>");
        out.print("<center><p id=\"username\">@" + d.getStatus() + "</p></center>");
        out.print("<center><p id=\"fullname\">" + d.getName() + "</p></center>");

        response.sendRedirect("order.jsp");
    }
}
