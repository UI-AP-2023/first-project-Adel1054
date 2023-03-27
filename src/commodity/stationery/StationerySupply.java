package commodity.stationery;

import category.Category;
import commodity.Commodity;

public class StationerySupply extends Commodity {
    protected final String country;
    StationerySupply(String ID, String name, double price, int availableCount, Category category,String country){
        super(ID,name,price,availableCount,category);
        this.country=country;
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

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return super.toString()+" Made in "+country;
    }
}