package model.commodity.stationery;

import model.category.Category;
import model.rating.Rating;

import java.util.ArrayList;

public class Notebook extends StationerySupply {
    private final int numberOfPages;
    private final String pageType;
    Notebook(String name, double price, int availableCount, Category category,String country, int numberOfPages, String pageType){
        super(name,price,availableCount,category,country);
        this.numberOfPages=numberOfPages;
        this.pageType=pageType;
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
    public String getCountry() {
        return super.getCountry();
    }

    @Override
    public String getName() {
        return super.getName();
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
    public void setAverageRating() {
        super.setAverageRating();
    }

    public String getPageType() {
        return pageType;
    }

    public int getNumberOfPages() {
        return numberOfPages;
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
        return super.toString()+" Number of pages: "+numberOfPages+" Page type: "+pageType;
    }
}
