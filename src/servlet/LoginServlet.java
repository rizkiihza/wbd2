package servlet;

import com.google.gson.Gson;
import database.MySQLConnect_Account;
import identityservice.RandomString;
import identityservice.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

//        out.println(username);

        if (validateLogin(username, password)) {

            String token = generateToken();

            User user = new User(username, password, token);

            updateTokenToDatabase(user);

            HttpSession session = request.getSession(true);
            session.setAttribute("UNUserAktif", user.getUsername());
            session.setAttribute("TokenUserAktif", user.getToken());

            String url = request.getContextPath() + "/index.jsp";
            response.sendRedirect(url);

        } else {
            out.println("Sorry UserName or Password Error!");

            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

            rd.include(request, response);
        }


    }

    private void updateTokenToDatabase(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            //Open a connection
            System.out.println("[Register Connecting to database ...");
            MySQLConnect_Account.connect();

            conn = MySQLConnect_Account.getConn();

            //Execute a query
            System.out.println("Creating statement...");
            String sql = "UPDATE user SET token = ? WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);

            // set the preparedstatement parameters
            stmt.setString(1, user.getToken());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());

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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");

        System.out.println(token);

        if (token == null) {
            String url = request.getContextPath() + "/login.jsp";
            response.sendRedirect(url);
        }
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
