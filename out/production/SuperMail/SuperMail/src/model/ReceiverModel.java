package model;

public class ReceiverModel {
    private int receiver_ID;
    private String receiver_Name;
    private String receiver_Postal_Code;
    private String receiver_Address;

    public ReceiverModel(int receiver_ID, String receiver_Name, String receiver_Postal_Code, String receiver_Address) {
        this.receiver_ID = receiver_ID;
        this.receiver_Name = receiver_Name;
        this.receiver_Postal_Code = receiver_Postal_Code;
        this.receiver_Address = receiver_Address;
    }

    public ReceiverModel(){

    }
    public int getReceiver_ID() {
        return receiver_ID;
    }

    public void setReceiver_ID(int receiver_ID) {
        this.receiver_ID = receiver_ID;
    }

    public String getReceiver_Name() {
        return receiver_Name;
    }

    public void setReceiver_Name(String receiver_Name) {
        this.receiver_Name = receiver_Name;
    }

    public String getReceiver_Postal_Code() {
        return receiver_Postal_Code;
    }

    public void setReceiver_Postal_Code(String receiver_Postal_Code) {
        this.receiver_Postal_Code = receiver_Postal_Code;
    }

    public String getReceiver_Address() {
        return receiver_Address;
    }

    public void setReceiver_Address(String receiver_Address) {
        this.receiver_Address = receiver_Address;
    }
}
