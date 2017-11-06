package profile;

import database.MySQLconnect;
import ws.OjekWS;
import ws.OjekWSImplService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class profile {
    public String ID;
    public String Name;
    public String Username;
    public String Email;
    public String Phone;
    public String Driver;
    public String Foto;
}
