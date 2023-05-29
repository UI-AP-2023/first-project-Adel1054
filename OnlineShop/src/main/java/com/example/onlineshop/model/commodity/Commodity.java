package com.example.onlineshop.model.commodity;



import com.example.onlineshop.model.user.consumer.Comment;
import com.example.onlineshop.model.user.consumer.Rating;

import java.util.ArrayList;

public abstract class Commodity implements Comparable {
    private String ID;
    private String name;
    private double price;
    private int availableCount;
    private String available;
    private int ratingsCount;
    private int commentsCount;
    private final ArrayList<Rating> ratings;
    private final ArrayList<Comment> comments;
    private double averageRating;
    private final Category category;
    private final int categoryNum;
    private static int comestibleCount = 1;
    private static int digitalCount = 1;
    private static int stationeryCount = 1;
    private static int vehicleCount = 1;
    private boolean discounted;
    private int discountCap;
    private double discount;

    protected Commodity(String name, double price, int availableCount, Category category) {
        this.availableCount = availableCount;
        if(availableCount>0){
            available="Yes";
        }else {
            available="No";
        }
        this.name = name;
        this.category = category;
        this.price = price;
        ratings = new ArrayList<>();
        comments = new ArrayList<>();
        ratingsCount=0;
        commentsCount=0;
        averageRating = 0;
        ID = IDBuilder();
        switch (category) {
            case DIGITAL:
                categoryNum = 4;
                break;
            case VEHICLE:
                categoryNum = 3;
                break;
            case STATIONERY:
                categoryNum = 2;
                break;
            case COMESTIBLE:
                categoryNum = 1;
                break;
            default:
                categoryNum = 0;
                break;
        }
        discounted=false;
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
        if (ratings.size() != 0) {
            averageRating = sum / (ratings.size());
        } else averageRating = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void changeAvailableCount(int change) {
        availableCount += change;
        if(availableCount<=0){
            available="No";
        }else {
            available="Yes";
        }
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public String getAvailable() {
        return available;
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

    public boolean isDiscounted() {
        return discounted;
    }

    public int getDiscountCap() {
        return discountCap;
    }

    public void setDiscountCap(int discountCap) {
        this.discountCap = discountCap;
    }

    public void setDiscounted(boolean discounted) {
        this.discounted = discounted;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Name: " + name + " ID: " + ID + " Category: " + category + " Price: " + price + "$" + " Available count: " + availableCount + " Number of comments: " + comments.size() + " Number of ratings: " + getRatingsCount() + " Average rating: " + averageRating;
    }

    @Override
    public int compareTo(Object o) {
        Commodity commodity = (Commodity) o;
        if (categoryNum < commodity.categoryNum) {
            return 1;
        } else if (categoryNum > commodity.categoryNum) {
            return -1;
        } else {
            if (getName().compareTo(commodity.getName()) > 0) {
                return 1;
            } else if (getName().compareTo(commodity.getName()) < 0) {
                return -1;
            } else {
                if (getAverageRating() > commodity.getAverageRating()) {
                    return 1;
                } else if (getAverageRating() < commodity.getAverageRating()) {
                    return -1;
                } else {
                    if (getPrice() > commodity.getPrice()) {
                        return 1;
                    } else if (getPrice() < commodity.getPrice()) {
                        return -1;
                    } else {
                        if (getAvailableCount() > commodity.getAvailableCount()) {
                            return 1;
                        } else if (getAvailableCount() < commodity.getAvailableCount()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }
    }

    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

}
