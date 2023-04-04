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

    public BicycleType getBicycleType() {
        return bicycleType;
    }

    @Override
    public String toString() {
        return super.toString() + " Bicycle type: " + bicycleType;
    }
}
