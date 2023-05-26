package com.example.onlineshop.model.commodity.vehicles;


import com.example.onlineshop.model.commodity.Category;
import com.example.onlineshop.model.commodity.Commodity;

public abstract class Vehicle extends Commodity {
    protected final String companyName;

    protected Vehicle(String name, double price, int availableCount, String companyName) {
        super(name, price, availableCount, Category.VEHICLE);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return super.toString() + " Company name: " + companyName;
    }
}
