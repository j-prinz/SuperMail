package model;

public class PostOfficeDetailsModel {
    private int POID;
    private String location;
    private String city;

    public PostOfficeDetailsModel(int POID, String location, String city) {
        this.POID = POID;
        this.location = location;
        this.city = city;
    }

    public int getPOID() {
        return POID;
    }

    public void setPOID(int POID) {
        this.POID = POID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
