package history;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class history {

    private String ID;
    private String name;
    private boolean isHidden;
    private String comment;
    private String date;
    private String pick;
    private String dest;
    private String img;

    public history () {

    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPick() {
        return pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String toJson() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    public void fromJson(String s) {
        Gson gson = new GsonBuilder().create();
        history temp = gson.fromJson(s, history.class);

        ID = temp.ID;
        name = temp.name;
        isHidden = temp.isHidden;
        comment = temp.comment;
        date = temp.date;
        pick = temp.date;
        dest = temp.dest;
        img = temp.img;
    }

}
