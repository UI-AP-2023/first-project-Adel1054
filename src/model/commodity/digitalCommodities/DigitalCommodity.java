package model.commodity.digitalCommodities;

import model.commodity.Category;
import model.commodity.Commodity;
import model.user.consumer.Rating;

import java.util.ArrayList;

public abstract class DigitalCommodity extends Commodity {
    private final double weight;
    private final String dimensions;

    protected DigitalCommodity(String name, double price, int availableCount, double weight, String dimensions) {
        super(name, price, availableCount, Category.DIGITAL);
        this.dimensions = dimensions;
        this.weight = weight;
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
    public void setAverageRating() {
        super.setAverageRating();
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public ArrayList<Rating> getRatings() {
        return super.getRatings();
    }

    @Override
    public void changeAvailableCount(int change) {
        super.changeAvailableCount(change);
    }

    public double getWeight() {
        return weight;
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

    @Override
    public String toString() {
        return super.toString() + " Weight: " + weight + " Dimensions: " + dimensions;
    }
}
