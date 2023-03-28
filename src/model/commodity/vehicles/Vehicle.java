package model.commodity.vehicles;

import model.category.Category;
import model.commodity.Commodity;
import model.rating.Rating;

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
    public double getAverageRating() {
        return super.getAverageRating();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
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
    public String getID() {
        return super.getID();
    }

    @Override
    public String getName() {
        return super.getName();
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
        return super.toString() + " Company name: " + companyName;
    }
}
