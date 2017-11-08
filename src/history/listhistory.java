package history;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class listhistory {

    private ArrayList<history> list;

    public listhistory() {
        list = new ArrayList<history>();
    }

    public ArrayList<history> getList() {
        return list;
    }

    public void setList(ArrayList<history> list) {
        this.list = list;
    }

    public void fromJson(String s){
        Gson gson = new GsonBuilder().create();
        listhistory temp = gson.fromJson(s, listhistory.class);

        for(int i = 0; i < temp.list.size(); i++) {
            list.add(temp.list.get(i));
        }
    }

    public String toJson(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }



}
