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

        out.print("<p class=\"title-complete-order\">HOW WAS IT?</p>");
//        out.print("<img id="img"class="img-profile" alt="Nama" src="http://mikatan.goodsmile.info/en/wp-content/uploads/-000//1/59659d3d855bb_2017-07-12-44379.jpg" >
        out.print("<center>@" + d.getStatus() + "</center>");
        out.print("<center>" + d.getName() + "</center>");
    }
}
