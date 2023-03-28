package model.commodity.comestible;

import model.commodity.Category;
import model.commodity.Commodity;
import model.rating.Rating;

import java.util.ArrayList;

public class Comestible extends Commodity {
    private final String productionDate;
    private final String expirationDate;

    public Comestible(String name, double price, int availableCount, String productionDate, String expirationDate) {
        super(name, price, availableCount, Category.COMESTIBLE);
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
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

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getProductionDate() {
        return productionDate;
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
    public String toString() {
        return super.toString() + " Production: " + productionDate + "\nExpiration: " + expirationDate;
    }
}
