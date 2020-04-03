package model;

public class EmployeeWorkAreaModel {
    private int EID;
    private String work_Area;

    public EmployeeWorkAreaModel(int EID, String work_Area) {
        this.EID = EID;
        this.work_Area = work_Area;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public String getWork_Area() {
        return work_Area;
    }

    public void setWork_Area(String work_Area) {
        this.work_Area = work_Area;
    }
}
