package beans;

public class Driver {
    private String id;
    private String prefLocation;

    public Driver(String id, String prefLocation) {
        this.id = id;
        this.prefLocation = prefLocation;
    }

    public String getId() {
        return id;
    }

    public String getPrefLocation() {
        return prefLocation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrefLocation(String prefLocation) {
        this.prefLocation = prefLocation;
    }
}
