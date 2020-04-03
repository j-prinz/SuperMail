package model;

public class DeliveryOrderModel {
    private int order_ID;
    private int customer_ID;
    private int EID;
    private String date; //probably should be Date class, come back later
    private String delivery_Status;
    private double pricing;
    private int receiver_ID;

    public DeliveryOrderModel(int order_ID, int customer_ID, int EID, String date, String delivery_Status, double pricing, int receiver_ID) {
        this.order_ID = order_ID;
        this.customer_ID = customer_ID;
        this.EID = EID;
        this.date = date;
        this.delivery_Status = delivery_Status;
        this.pricing = pricing;
        this.receiver_ID = receiver_ID;
    }

    public int getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDelivery_Status() {
        return delivery_Status;
    }

    public void setDelivery_Status(String delivery_Status) {
        this.delivery_Status = delivery_Status;
    }

    public double getPricing() {
        return pricing;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public int getReceiver_ID() {
        return receiver_ID;
    }

    public void setReceiver_ID(int receiver_ID) {
        this.receiver_ID = receiver_ID;
    }
}
