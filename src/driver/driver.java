package driver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class driver {
    private int ID;
    private String name;
    private float rate;
    private int voter;
    private String status;
    private String foto;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getVoter() {
        return voter;
    }

    public void setVoter(int voter) {
        this.voter = voter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void fromJson(String in) {
        Gson gson = new GsonBuilder().create();
        driver d = gson.fromJson(in, driver.class);
        this.ID = d.getID();
        this.name = d.getName();
        this.rate = d.getRate();
        this.voter = d.getVoter();
        this.status = d.getStatus();
        this.foto = d.getFoto();
    }

    public String toJson() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

}
