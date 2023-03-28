package model.commodity.stationery;

import model.category.Category;
import model.rating.Rating;

import java.util.ArrayList;

public class Pencil extends StationerySupply {
    private enum PencilType {
        H2,H,F,B,HB
    }
    private final PencilType pencilType;
    Pencil(String ID, String name, double price, int availableCount, Category category,String country, PencilType pencilType){
        super(ID,name,price,availableCount,category,country);
        this.pencilType=pencilType;
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
    public String getName() {
        return super.getName();
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
    public String getCountry() {
        return super.getCountry();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
    }

    public PencilType getPencilType() {
        return pencilType;
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
        return super.toString()+" Pencil type: "+pencilType;
    }
}
