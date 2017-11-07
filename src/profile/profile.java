package profile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    public String AvgRating;
    public String Vote;

    public void fromJson(String s){
        Gson gson = new GsonBuilder().create();
        profile temp = gson.fromJson(s, profile.class);
        ID = temp.ID;
        Name = temp.Name;
        Username = temp.Username;
        Email = temp.Email;
        Phone = temp.Phone;
        Driver = temp.Driver;
        Foto = temp.Foto;

        if(Driver.equals("1")) {
            AvgRating = temp.AvgRating;
            Vote = temp.Vote;
        } else {
            AvgRating ="";
            Vote = "";
        }
    }

    public String toJson(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
