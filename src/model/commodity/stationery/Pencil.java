package model.commodity.stationery;

import model.commodity.Category;
import model.rating.Rating;

import java.util.ArrayList;

public class Pencil extends StationerySupply {
    public enum PencilType {
        H2, H, F, B, HB
    }

    private final PencilType pencilType;

    public Pencil(String name, double price, int availableCount, String country, PencilType pencilType) {
        super(name, price, availableCount, country);
        this.pencilType = pencilType;
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

    @Override
    public void setAvailableCount(int availableCount) {
        super.setAvailableCount(availableCount);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public int getAvailableCount() {
        return super.getAvailableCount();
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
        return super.toString() + " Pencil type: " + pencilType;
    }
}
