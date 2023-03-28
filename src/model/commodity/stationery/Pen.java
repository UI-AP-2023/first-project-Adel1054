package model.commodity.stationery;

import model.commodity.Category;
import model.user.consumer.Rating;

import java.util.ArrayList;

public class Pen extends StationerySupply {
    private final String colour;

    public Pen(String name, double price, int availableCount, String country, String colour) {
        super(name, price, availableCount, country);
        this.colour = colour;
    }

    @Override
    public double getAverageRating() {
        return super.getAverageRating();
    }

    @Override
    public String getCountry() {
        return super.getCountry();
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

    @Override
    public int getAvailableCount() {
        return super.getAvailableCount();
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

    public String getColour() {
        return colour;
    }

    @Override
    public ArrayList<Rating> getRatings() {
        return super.getRatings();
    }

    @Override
    public void changeAvailableCount(int change) {
        super.changeAvailableCount(change);
    }

    @Override
    public String toString() {
        return super.toString() + " Pen colour: " + colour;
    }
}
