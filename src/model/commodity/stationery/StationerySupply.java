package model.commodity.stationery;

import model.commodity.Category;
import model.commodity.Commodity;
import model.user.consumer.Rating;

import java.util.ArrayList;

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