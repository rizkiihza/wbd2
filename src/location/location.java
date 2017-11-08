package location;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import profile.profile;

import java.util.ArrayList;
import java.util.List;

public class location {
    List<String> tempat;

    public location() {
        tempat = new ArrayList<>();
    }

    public void fromJson(String s){
        Gson gson = new GsonBuilder().create();
        location temp = gson.fromJson(s, location.class);

        for(int i = 0; i < temp.tempat.size(); i++) {
            tempat.add(temp.tempat.get(i));
        }
    }

    public String toJson(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
