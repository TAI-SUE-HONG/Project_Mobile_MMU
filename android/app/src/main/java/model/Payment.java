package model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.emart.disco.Cart_test;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Payment implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private String Location;
    private double Gross_payment;
    private static final int delivery = 3;
    private double Final_price;

    public Payment(String Location, double Gross_payment) {
        this.Location = Location;
        this.Gross_payment = Gross_payment;
        this.Final_price = Gross_payment + delivery;
    }

    @NonNull
    public String getLocation() {
        return Location;
    }

    public double getGross_payment() {
        return Gross_payment;
    }

    public double getFinal_price() {
        return Final_price;
    }

    public void setLocation(@NonNull String location) {
        Location = location;
    }

    public void setGross_payment(double gross_payment) {
        Gross_payment = gross_payment;
    }
}
