package model;

public class CustomerModel {
    private int customer_ID;
    private String customer_Name;
    private int customer_Phone;
    private String customer_Address;

    public CustomerModel(int customer_ID, String customer_Name, int customer_Phone, String customer_Address){
        setCustomer_ID(customer_ID);
        setCustomer_Name(customer_Name);
        setCustomer_Phone(customer_Phone);
        setCustomer_Address(customer_Address);
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public int getCustomer_Phone() {
        return customer_Phone;
    }

    public void setCustomer_Phone(int customer_Phone) {
        this.customer_Phone = customer_Phone;
    }

    public String getCustomer_Address() {
        return customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        this.customer_Address = customer_Address;
    }
}
