package servlet;

import database.MySQLConnect_Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("username");
        String p=request.getParameter("userpass");

        out.println(n);
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            MySQLConnect_Account.connect();

            conn = MySQLConnect_Account.getConn();

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            stmt = conn.prepareStatement(sql);

            //Bind values into the parameters.
            stmt.setString(1, n);  // This would set age
            stmt.setString(2, p); // This would set ID


            ResultSet rs = stmt.executeQuery();

            //STEP 5: Extract data from result set
            if (rs.next()){
               out.println("berhasil");
            } else {
                out.println("tidak berhasil");
            }
            //STEP 6: Clean-up environment
            rs.close();
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
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
