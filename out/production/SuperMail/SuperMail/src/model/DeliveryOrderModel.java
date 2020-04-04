package model;

import oracle.sql.DATE;

import java.sql.Date;

public class DeliveryOrderModel {
    private int order_ID;
    private int customer_ID;
    private int EID;
    private Date initial_date; //probably should be Date class, come back later
    private Date delivery_date;
    private String delivery_Status;
    private double pricing;
    private int receiver_ID;

    public DeliveryOrderModel(int order_ID, int customer_ID, int EID, Date initial_date, Date delivery_date, String delivery_Status, double pricing, int receiver_ID) {
        this.order_ID = order_ID;
        this.customer_ID = customer_ID;
        this.EID = EID;
        this.initial_date = initial_date;
        this.delivery_date = delivery_date;
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

    public Date getInitialDate() {
        return initial_date;
    }

    public void setInitialDate(Date initial_date) {
        this.initial_date = initial_date;
    }

    public Date getDeliveryDate() {
        return delivery_date;
    }

    public void setDeliveryDate(Date delivery_date) {
        this.initial_date = this.delivery_date;
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
