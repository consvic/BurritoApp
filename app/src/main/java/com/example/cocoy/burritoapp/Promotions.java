package com.example.cocoy.burritoapp;

/**
 * Created by cocoy on 24/10/2017.
 */

public class Promotions {
    private int photoPromo;
    private String promotion;
    private String dateAvailable;


    public Promotions(int photoPromo, String promotion, String dateAvailable) {
        this.photoPromo = photoPromo;
        this.promotion = promotion;
        this.dateAvailable = dateAvailable;
    }

    public String getPromotion() {
        return promotion;
    }

    public String getDateAvailable() {
        return dateAvailable;
    }

    public int getPhotoPromo() {
        return photoPromo;
    }
}
