package model;

public class ItemsModel {
    int item_ID;
    int order_ID;
    int length;
    int width;
    int height;
    int weight;
    boolean fragility;

    public ItemsModel(int item_ID, int order_ID, int length, int width, int height, int weight, boolean fragility) {
        this.item_ID = item_ID;
        this.order_ID = order_ID;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.fragility = fragility;
    }

    public int getItem_ID() {
        return item_ID;
    }

    public void setItem_ID(int item_ID) {
        this.item_ID = item_ID;
    }

    public int getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isFragility() {
        return fragility;
    }

    public void setFragility(boolean fragility) {
        this.fragility = fragility;
    }
}
