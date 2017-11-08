package servlet;

import database.MySQLConnect_Account;
import database.MySQLconnect;
import identityservice.RandomString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.concurrent.Semaphore;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String checkbox = "No";
        //Inisialisasi Variabel
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String confirm_password = request.getParameter("confirm_password");
        String phone = request.getParameter("phone");
        if (request.getParameter("is_driver") != null) {
            checkbox = request.getParameter("is_driver");
        }


//        System.out.println("Checkbox : " + checkbox);

        registerUserforDatabaseAccount(fullname, username, email, password, confirm_password, phone, checkbox);
//        registerUserforDatabaseOjek(fullname, username, email, password, confirm_password, phone, checkbox);

        HttpSession session = request.getSession(true);
        session.setAttribute("RegisterFullname", fullname);
        session.setAttribute("RegisterUsername", username);
        session.setAttribute("RegisterEmail", email);
        session.setAttribute("RegisterPassword", password);
        session.setAttribute("RegisterPhone", phone);
        session.setAttribute("RegisterCheckbox", checkbox.equals("Yes") ? "1"  : "0" );

        String url = request.getContextPath() + "/register_temp.jsp";
        response.sendRedirect(url);
//        registerUserforDatabaseAccount(fullname, username, email, password, confirm_password, phone, checkbox);

    }

    private void registerUserforDatabaseOjek(String fullname, String username, String email, String password, String confirm_password, String phone, String checkbox) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String token = generateToken();

        try{
            //Open a connection
            System.out.println("Register Connecting to database ...");
            MySQLconnect.connect();

            conn = MySQLconnect.getConn();

            //Execute a query
            System.out.println("Creating statement...");
            String sql = "INSERT INTO profil (Username, Email, Password, Name, Phone, Driver ) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // set the preparedstatement parameters
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, fullname);
            stmt.setString(5, phone);
            stmt.setString(6, checkbox.equals("Yes") ? "1"  : "0" );

            //INSERT INTO user (username, password, name, token, email , phone ) VALUES (?, ?, ?, ?, ?, ?)


            stmt.executeUpdate();

            //STEP 6: Clean-up environment

            stmt.close();
            conn.close();

            System.out.println("Register berhasil");

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

    }

    private void registerUserforDatabaseAccount(String fullname, String username,  String email,  String password, String confirm_password, String phone, String checkbox) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String token = generateToken();

        try{
            //Open a connection
            System.out.println("Register Connecting to database ...");
            MySQLConnect_Account.connect();

            conn = MySQLConnect_Account.getConn();

            //Execute a query
            System.out.println("Creating statement...");
            String sql = "INSERT INTO user (username, email, password, name, token, phone, is_driver ) VALUES (?, ?, ?, ?, ?, ? , ?)";
            stmt = conn.prepareStatement(sql);

            // set the preparedstatement parameters
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, fullname);
            stmt.setString(5, token);
            stmt.setString(6, phone);
            stmt.setString(7, checkbox.equals("Yes") ? "1"  : "0" );

            //INSERT INTO user (username, password, name, token, email , phone ) VALUES (?, ?, ?, ?, ?, ?)


            stmt.executeUpdate();

            //STEP 6: Clean-up environment

            stmt.close();
            conn.close();

            System.out.println("Register berhasil");

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


    private String generateToken() {
        String alphanumeric = RandomString.digits + "ACEFGHJKLMNPQRUVWXYabcdefhijkprstuvwx";

        RandomString token = new RandomString(20, new SecureRandom(), alphanumeric);

        return token.getRandomString();
    }

}
