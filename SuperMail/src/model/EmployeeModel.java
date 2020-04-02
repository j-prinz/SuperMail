package model;

public class EmployeeModel {
    private int EID;
    private String e_name;
    private int e_phone;

    public EmployeeModel(int EID, String e_name, int e_phone) {
        this.EID = EID;
        this.e_name = e_name;
        this.e_phone = e_phone;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public int getE_phone() {
        return e_phone;
    }

    public void setE_phone(int e_phone) {
        this.e_phone = e_phone;
    }
}
