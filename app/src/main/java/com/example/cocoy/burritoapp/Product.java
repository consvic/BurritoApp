package com.example.cocoy.burritoapp;

/**
 * Created by cocoy on 24/10/2017.
 */

public class Product {
    private String product_name;
    private String seller;
    private int price;
    private int available;

    public Product(String product_name, String seller, int price, int available) {
        this.product_name = product_name;
        this.seller = seller;
        this.price = price;
        this.available = available;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getSeller() {
        return seller;
    }

    public int getPrice() {
        return price;
    }

    public int getAvailable() {
        return available;
    }
}
