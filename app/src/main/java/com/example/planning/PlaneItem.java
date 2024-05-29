package com.example.planning;

public class PlaneItem {
    private String price;
    private String item;
    private String type;

    public PlaneItem(String price, String item, String type) {
        this.price = price;
        this.item = item;
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public String getItem() {
        return item;
    }

    public String getType() {
        return type;
    }
}