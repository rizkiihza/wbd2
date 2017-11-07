package servlet;

import database.MySQLConnect_Account;
import identityservice.RandomString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("userpass");

        out.println(username);

        if (validateLogin(username, password)) {



        } else {
            out.println( "tidak berhasil" );
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String generateToken() {
        String alphanumeric = RandomString.digits + "ACEFGHJKLMNPQRUVWXYabcdefhijkprstuvwx";

        RandomString token = new RandomString(20, new SecureRandom(), alphanumeric);

        return token.getRandomString();
    }

    private boolean validateLogin (String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;

        boolean status = false;

        try{
            //Open a connection
            System.out.println("Connecting to database...");
            MySQLConnect_Account.connect();

            conn = MySQLConnect_Account.getConn();

            //Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            stmt = conn.prepareStatement(sql);

            //Bind values into the parameters.
            stmt.setString(1, username);  // This would set age
            stmt.setString(2, password); // This would set ID


            ResultSet rs = stmt.executeQuery();

            //User ditemukan
            //Dilakukan generate token baru
            //Dilakukan update token
            if (rs.next()) {
                status = true;

                String token = generateToken();
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


        return status;


    }

}
