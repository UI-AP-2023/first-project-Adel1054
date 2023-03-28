package model.commodity.stationery;

import model.commodity.Category;
import model.commodity.Commodity;
import model.rating.Rating;

import java.util.ArrayList;

public abstract class StationerySupply extends Commodity {
    protected final String country;

    protected StationerySupply(String name, double price, int availableCount, String country) {
        super(name, price, availableCount, Category.STATIONERY);
        this.country = country;
    }

    @Override
    public double getAverageRating() {
        return super.getAverageRating();
    }

    @Override
    public Category getCategory() {
        return super.getCategory();
    }

    @Override
    public String getID() {
        return super.getID();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
    }

    public String getCountry() {
        return country;
    }

    @Override
    public ArrayList<Rating> getRatings() {
        return super.getRatings();
    }

    @Override
    public void setAvailableCount(int availableCount) {
        super.setAvailableCount(availableCount);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getAvailableCount() {
        return super.getAvailableCount();
    }

    @Override
    public void changeAvailableCount(int change) {
        super.changeAvailableCount(change);
    }

    @Override
    public String toString() {
        return super.toString() + " Made in " + country;
    }
}