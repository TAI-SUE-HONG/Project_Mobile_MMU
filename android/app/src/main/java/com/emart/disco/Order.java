package com.emart.disco;

public class Order {
    private String Title;
    private String Value;

    public Order(String Title, String Value) {
        this.Title = Title;
        this.Value = Value;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getValue() {
        return this.Value;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public void setValue(String value) {
        this.Value = value;
    }
}
