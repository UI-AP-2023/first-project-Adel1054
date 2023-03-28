package model.commodity.digitalCommodities;

import model.category.Category;
import model.rating.Rating;

import java.util.ArrayList;

public class PC extends DigitalCommodity {
    private final int ramCapacity;
    private final String cpuType;
    PC(String name, double price, int availableCount,  double weight, String dimensions,int ramCapacity,String cpuType){
        super(name,price,availableCount,weight,dimensions);
        this.cpuType=cpuType;
        this.ramCapacity=ramCapacity;
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
    public String getDimensions() {
        return super.getDimensions();
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

    public int getRamCapacity() {
        return ramCapacity;
    }

    public String getCpuType() {
        return cpuType;
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
        return super.toString()+" Ram capacity: "+ramCapacity+" CPU type: "+cpuType;
    }
}
