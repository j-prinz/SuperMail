package model;

public class PostOfficeModel {
    private String receiver_Postal_Code;
    private int POID;

    public PostOfficeModel(String receiver_Postal_Code, int POID) {
        this.receiver_Postal_Code = receiver_Postal_Code;
        this.POID = POID;
    }

    public String getReceiver_Postal_Code() {
        return receiver_Postal_Code;
    }

    public void setReceiver_Postal_Code(String receiver_Postal_Code) {
        this.receiver_Postal_Code = receiver_Postal_Code;
    }

    public int getPOID() {
        return POID;
    }

    public void setPOID(int POID) {
        this.POID = POID;
    }
}
