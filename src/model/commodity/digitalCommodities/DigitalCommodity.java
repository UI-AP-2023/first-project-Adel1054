package model.commodity.digitalCommodities;

import model.category.Category;
import model.commodity.Commodity;

public abstract class DigitalCommodity extends Commodity {
    protected final double weight;
    protected final String dimensions;
    DigitalCommodity(String ID, String name, double price, int availableCount, Category category,double weight,String dimensions){
        super(ID,name,price,availableCount,category);
        this.dimensions=dimensions;
        this.weight=weight;
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
    public String toString() {
        return super.toString()+" Weight: "+weight+" Dimensions: "+dimensions;
    }
}
