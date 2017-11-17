<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="database.MySQLconnect" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: hilmi
  Date: 08/11/2017
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String fullname = (String) session.getAttribute("RegisterFullname");
    String username = (String) session.getAttribute("RegisterUsername");
    String email = (String) session.getAttribute("RegisterEmail");
    String password = (String) session.getAttribute("RegisterPassword");
    String phone = (String) session.getAttribute("RegisterPhone");
    String checkbox = (String) session.getAttribute("RegisterCheckbox");


    out.println(fullname);
    out.println(username);
    out.println(email);
    out.println(password);
    out.println(phone);
    out.println(checkbox);
    Connection conn = null;
    PreparedStatement stmt = null;


    try{
        //Open a connection
        System.out.println("Register Connecting to database ...");
        MySQLconnect.connect();

        conn = MySQLconnect.getConn();

        //Execute a query
        System.out.println("Creating statement...");
        String sql = "INSERT INTO profil (Username, Email, Password, Name, Phone, Driver , foto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);

        // set the preparedstatement parameters
        stmt.setString(1, username);
        stmt.setString(2, email);
        stmt.setString(3, password);
        stmt.setString(4, fullname);
        stmt.setString(5, phone);
        stmt.setString(6, checkbox.equals("Yes") ? "1"  : "0" );
        stmt.setString(7, "/foto.img");

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

    String site = new String("login.jsp");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
    // redirect('login.jsp')

%>