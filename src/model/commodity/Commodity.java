package model.commodity;

import model.category.Category;
import model.rating.Rating;

import java.util.ArrayList;

public abstract class Commodity {
    private final String ID;
    private String name;
    private double price;
    private int availableCount;
    private final ArrayList<Rating> ratings;
    private double averageRating;
    private final Category category;
    private static int comestibleCount;
    private static int digitalCount;
    private static int stationeryCount;
    private static int vehicleCount;
    protected Commodity( String name, double price, int availableCount, Category category) {
        this.availableCount = availableCount;
        this.name = name;
        this.category = category;
        this.price = price;
        ratings = new ArrayList<>();
        averageRating = -1;
        this.ID=IDBuilder();
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

    public void changeAvailableCount(int change) {
        availableCount += change;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }
    private String IDBuilder(){
        StringBuilder ID=new StringBuilder();
        ID.append(name, 0, 4);
        ID.append(category.toString(),0,4);
        return ID.toString();
    }

    @Override
    public String toString() {
        return "Name: "+name+" ID: "+ID+" Category: "+category+" Average rating: "+averageRating+" Price: "+price;
    }
}
