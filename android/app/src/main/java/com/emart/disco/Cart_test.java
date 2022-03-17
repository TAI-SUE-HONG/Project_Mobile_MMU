package com.emart.disco;

public class Cart_test {
    private int id;
    private int date;
    private double price;
    private String description;

    public Cart_test(int id, int date, double price) {
        this.id = id;
        this.date = date;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public int getDate() {
        return this.date;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description = "DISCO cart " + Double.toString(this.price);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
