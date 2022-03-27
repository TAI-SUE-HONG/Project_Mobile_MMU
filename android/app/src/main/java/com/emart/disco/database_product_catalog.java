package com.emart.disco;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "database_product_catalog")

public class database_product_catalog {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_price")
    private float product_price;
    @ColumnInfo(name = "productName")
    private String name;
    private int quantity;
    public database_product_catalog(String name, int quantity) {
        this.product_price = product_price;
        this.name = name;
        this.quantity = quantity;
    }
    public float product_price() {
        return this.product_price;
    }
    public String getName() {
        return this.name;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public void setId(float product_price) {
        this.product_price = product_price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
