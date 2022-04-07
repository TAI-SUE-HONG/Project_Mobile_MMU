package model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;

import java.io.Serializable;

@Entity(primaryKeys = {"Name"})
public class Cart implements Serializable{
    @NonNull
    public String Name;
    public int Quantity;
    public double Price;

    @Ignore
    public String Location;

    public Cart(String Name, int Quantity, double Price) {
        this.Name = Name;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    @NonNull

    public String getName() {
        return Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public double getPrice() {
        return Price*Quantity;
    }

    public String getLocation() {
        return Location;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLocation(String location) {
        Location = location;
    }


}