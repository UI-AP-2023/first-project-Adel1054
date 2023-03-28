package model.commodity;

import model.category.Category;
import model.rating.Rating;

import java.util.ArrayList;

public abstract class Commodity {
    protected final String ID;
    protected final String name;
    protected final double price;
    protected int availableCount;
    protected ArrayList<Rating> ratings;
    protected double averageRating;
    protected Category category;

    protected Commodity(String ID, String name, double price, int availableCount, Category category) {
        this.availableCount = availableCount;
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.price = price;
        ratings = new ArrayList<>();
        averageRating = -1;
    }

    public double getPrice() {
        return price;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating() {
        double sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getUserRating();
        }
        averageRating = sum / (ratings.size());
    }

    @Override
    public String toString() {
        return "Name: "+name+" ID: "+ID+" Category: "+category+" Average rating: "+averageRating+" Price: "+price;
    }
}
