package model.commodity.vehicles;

import model.commodity.Category;
import model.commodity.Commodity;
import model.user.consumer.Rating;

import java.util.ArrayList;

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
