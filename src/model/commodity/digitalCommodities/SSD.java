package model.commodity.digitalCommodities;

import model.category.Category;
import model.rating.Rating;

import java.util.ArrayList;

public class SSD extends StorageDevices {
    private final double readSpeed;
    private final double writeSpeed;
    SSD(String name, double price, int availableCount, Category category, double weight, String dimensions, double capacity,double readSpeed,double writeSpeed){
        super(name,price,availableCount,category,weight,dimensions,capacity);
        this.writeSpeed=writeSpeed;
        this.readSpeed=readSpeed;
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
    public double getCapacity() {
        return super.getCapacity();
    }

    public double getWriteSpeed() {
        return writeSpeed;
    }

    public double getReadSpeed() {
        return readSpeed;
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
        return super.toString()+" Write speed: "+writeSpeed+" Read speed: "+readSpeed;
    }
}
