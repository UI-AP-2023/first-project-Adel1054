package model.commodity.vehicles;

import model.commodity.Category;
import model.user.consumer.Rating;

import java.util.ArrayList;

public class Bicycle extends Vehicle {
    public enum BicycleType {
        MOUNTAIN, ROAD, CITY, HYBRID
    }

    private final BicycleType bicycleType;

    public Bicycle(String name, double price, int availableCount, String companyName, BicycleType bicycleType) {
        super(name, price, availableCount, companyName);
        this.bicycleType = bicycleType;
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
    public String getCompanyName() {
        return super.getCompanyName();
    }

    public BicycleType getBicycleType() {
        return bicycleType;
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
        return super.toString() + " Bicycle type: " + bicycleType;
    }
}
