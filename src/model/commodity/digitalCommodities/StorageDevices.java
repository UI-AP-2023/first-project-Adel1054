package model.commodity.digitalCommodities;

import model.category.Category;
import model.rating.Rating;

import java.util.ArrayList;

public abstract class StorageDevices extends model.commodity.digitalCommodities.DigitalCommodity {
    private final double capacity;
    StorageDevices(String name, double price, int availableCount, double weight, String dimensions,double capacity){
        super(name,price,availableCount,weight,dimensions);
        this.capacity=capacity;
    }

    @Override
    public double getAverageRating() {
        return super.getAverageRating();
    }

    @Override
    public String getDimensions() {
        return super.getDimensions();
    }

    @Override
    public Category getCategory() {
        return super.getCategory();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getID() {
        return super.getID();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public ArrayList<Rating> getRatings() {
        return super.getRatings();
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public void changeAvailableCount(int change) {
        super.changeAvailableCount(change);
    }

    @Override
    public String toString() {
        return super.toString()+" Capacity: "+capacity;
    }
}