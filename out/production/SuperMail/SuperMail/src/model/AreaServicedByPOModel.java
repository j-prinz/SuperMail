package model;

public class AreaServicedByPOModel {
    private int POID;
    private char work_area;

    public AreaServicedByPOModel(int POID, char work_area){
        setPOID(POID);
        setWorkArea(work_area);
    }

    public int getPOID() {
        return POID;
    }

    public void setPOID(int customer_ID) {
        this.POID = POID;
    }

    public char getWorkArea() {
        return work_area;
    }

    public void setWorkArea(char work_area) {
        this.work_area = work_area;
    }

}
