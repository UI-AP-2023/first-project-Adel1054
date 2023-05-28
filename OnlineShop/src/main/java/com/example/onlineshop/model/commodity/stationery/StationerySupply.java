package com.example.onlineshop.model.commodity.stationery;


import com.example.onlineshop.model.commodity.Category;
import com.example.onlineshop.model.commodity.Commodity;

public abstract class StationerySupply extends Commodity {
    protected final String country;

    protected StationerySupply(String name, double price, int availableCount, String country) {
        super(name, price, availableCount, Category.STATIONERY);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return super.toString() + " Made in " + country;
    }
}