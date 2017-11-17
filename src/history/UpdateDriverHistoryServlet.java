package history;

import database.MySQLconnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "UpdateDriverHistoryServlet")
public class UpdateDriverHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String order_id = request.getParameter("order_id");

        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            MySQLconnect.connect();

            conn = MySQLconnect.getConn();

            //Execute a query
            System.out.println("Creating statement...");
            String sql = "UPDATE history SET HidCust= 1 WHERE Order_Id = ?";
            stmt = conn.prepareStatement(sql);

            // set the preparedstatement parameters
            stmt.setString(1, order_id);

            stmt.executeUpdate();

            //STEP 6: Clean-up environment

            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            } catch (SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        String url = request.getContextPath() + "/history.jsp?tampilan=kanan";
        response.sendRedirect(url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
