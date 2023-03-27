package commodity.vehicles;

import category.Category;
import commodity.Commodity;

public abstract class Vehicle extends Commodity {
    protected final String companyName;

    Vehicle(String ID, String name, double price, int availableCount, Category category, String companyName) {
        super(ID, name, price, availableCount, category);
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
    public String toString() {
        return super.toString() + " Company name: " + companyName;
    }
}
