package model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity(primaryKeys = {"ID"})
public class Payment implements Serializable {
    @NonNull
    public String Title;
    public String Value;

    @Ignore
    public String Name;
    public String Location;
    public double Gross_payment;
    public static final int delivery = 3;
    public double Final_price;
    public Date DDTT;

    public Payment(String Name, String Location, double Gross_payment) {
        this.Name = Name;
        this.Location = Location;
        this.Gross_payment = Gross_payment;
        this.Final_price = Gross_payment + delivery;
        this.DDTT = Calendar.getInstance().getTime();
    }

    @NonNull
    public String getTitle() {
        return Title;
    }

    public String getValue() {
        return Value;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public double getGross_payment() {
        return Gross_payment;
    }

    public double getFinal_price() {
        return Final_price;
    }

    public Date getDDTT() {
        return DDTT;
    }

    public void setTitle(@NonNull String title) {
        Title = title;
    }

    public void setValue(String value) {
        Value = value;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setGross_payment(double gross_payment) {
        Gross_payment = gross_payment;
    }
}
