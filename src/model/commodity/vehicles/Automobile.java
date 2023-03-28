package model.commodity.vehicles;

import model.commodity.Category;
import model.user.consumer.Rating;

import java.util.ArrayList;

public class Automobile extends Vehicle {
    private final boolean isAutomatic;
    private final int motorVolume;

    public Automobile(String name, double price, int availableCount, String companyName, boolean isAutomatic, int motorVolume) {
        super(name, price, availableCount, companyName);
        this.isAutomatic = isAutomatic;
        this.motorVolume = motorVolume;
    }

    @Override
    public double getAverageRating() {
        return super.getAverageRating();
    }

    @Override
    public void setAvailableCount(int availableCount) {
        super.setAvailableCount(availableCount);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public int getAvailableCount() {
        return super.getAvailableCount();
    }

    @Override
    public String getCompanyName() {
        return super.getCompanyName();
    }

    @Override
    public Category getCategory() {
        return super.getCategory();
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
    public String getID() {
        return super.getID();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
    }

    public int getMotorVolume() {
        return motorVolume;
    }

    public boolean isAutomatic() {
        return isAutomatic;
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
        return super.toString() + " Motor Volume: " + motorVolume + " Is automatic: " + isAutomatic;
    }
}
