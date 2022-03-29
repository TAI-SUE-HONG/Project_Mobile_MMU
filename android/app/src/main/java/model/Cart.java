package model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Cart implements Serializable{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private String Name;
    private int Quantity;
    private double price;
    private double total_price;
    private String date;


    public Cart(String Name, int Quantity, double price, double total_price, String date) {
        this.Name = Name;
        this.Quantity = Quantity;
        this.price = price;
        this.total_price = total_price;
        this.date = date;
    }

    public Cart(String name, double price) {
    }

    @NonNull

    public String getName() {
        return Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public double getTotal_price() {
        return total_price;
    }

    public String getDate() {
        return this.date;
    }

    public void setName(@NonNull String name) {
        Name = name;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public void setDate(String date) {
        this.date = date;
    }
}