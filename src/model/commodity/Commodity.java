package model.commodity;

import model.user.consumer.Comment;
import model.user.consumer.Rating;

import java.util.ArrayList;

public abstract class Commodity {
    private String ID;
    private String name;
    private double price;
    private int availableCount;
    private final ArrayList<Rating> ratings;
    private final ArrayList<Comment> comments;
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
        comments = new ArrayList<>();
        averageRating = 0;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void changeAvailableCount(int change) {
        availableCount += change;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    private String IDBuilder() {
        StringBuilder ID = new StringBuilder();
        ID.append(category.toString(), 0, 4);
        ID.append(name, 0, 4);
        switch (category) {
            case COMESTIBLE:
                switch (String.valueOf(comestibleCount).length()) {
                    case 1:
                        ID.append("000");
                        break;
                    case 2:
                        ID.append("00");
                        break;
                    case 3:
                        ID.append("0");
                        break;
                }
                ID.append(comestibleCount++);
                break;
            case DIGITAL:
                switch (String.valueOf(digitalCount).length()) {
                    case 1:
                        ID.append("000");
                        break;
                    case 2:
                        ID.append("00");
                        break;
                    case 3:
                        ID.append("0");
                        break;
                }
                ID.append(digitalCount++);
                break;
            case STATIONERY:
                switch (String.valueOf(stationeryCount).length()) {
                    case 1:
                        ID.append("000");
                        break;
                    case 2:
                        ID.append("00");
                        break;
                    case 3:
                        ID.append("0");
                        break;
                }
                ID.append(stationeryCount++);
                break;
            case VEHICLE:
                switch (String.valueOf(vehicleCount).length()) {
                    case 1:
                        ID.append("000");
                        break;
                    case 2:
                        ID.append("00");
                        break;
                    case 3:
                        ID.append("0");
                        break;
                }
                ID.append(vehicleCount++);
                break;
        }
        return ID.toString();
    }

    public static void addToDigitalCount() {
        Commodity.digitalCount++;
    }

    public static void addToComestibleCount() {
        comestibleCount++;
    }

    public static void addToStationeryCount() {
        Commodity.stationeryCount++;
    }

    public static void addToVehicleCount() {
        Commodity.vehicleCount++;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public int getRatingsCount() {
        return ratings.size();
    }

    public void setID() {
        this.ID = IDBuilder();
    }

    @Override
    public String toString() {
        return "Name: " + name + " ID: " + ID + " Category: " + category + " Price: " + price + "$"+" Available count: "+availableCount+" Number of comments: "+comments.size()+" Number of ratings: " + getRatingsCount() + " Average rating: " + averageRating;
    }
}
