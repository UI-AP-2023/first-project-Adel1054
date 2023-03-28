package model.commodity.stationery;

import model.category.Category;

public class Pen extends StationerySupply {
    private final String colour;
    Pen(String ID, String name, double price, int availableCount, Category category,String country, String colour){
        super(ID,name,price,availableCount,category,country);
        this.colour=colour;
    }

    @Override
    public double getAverageRating() {
        return super.getAverageRating();
    }

    @Override
    public String getCountry() {
        return super.getCountry();
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

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return super.toString()+" Pen colour: "+colour;
    }
}
