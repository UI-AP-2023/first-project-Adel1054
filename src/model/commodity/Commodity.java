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
    private static int comestibleCount = 1;
    private static int digitalCount = 1;
    private static int stationeryCount = 1;
    private static int vehicleCount = 1;

    protected Commodity(String name, double price, int availableCount, Category category) {
        this.availableCount = availableCount;
        this.name = name;
        this.category = category;
        this.price = price;
        ratings = new ArrayList<>();
        averageRating = -1;
        ID = IDBuilder();
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

    private String IDBuilder() {
        StringBuilder ID = new StringBuilder();
        ID.append(category.toString(), 0, 4);
        ID.append(name, 0, 4);
        switch (category) {
            case COMESTIBLE:
                ID.append(comestibleCount++);
                break;
            case DIGITAL:
                ID.append(digitalCount++);
                break;
            case STATIONERY:
                ID.append(stationeryCount++);
                break;
            case VEHICLE:
                ID.append(vehicleCount++);
                break;
        }
        return ID.toString();
    }

    @Override
    public String toString() {
        return "Name: " + name + " ID: " + ID + " Category: " + category + " Average rating: " + averageRating + " Price: " + price;
    }
}
