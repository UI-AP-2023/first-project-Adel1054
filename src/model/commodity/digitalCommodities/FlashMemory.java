package model.commodity.digitalCommodities;

import model.category.Category;
import model.rating.Rating;

import java.util.ArrayList;

public class FlashMemory extends model.commodity.digitalCommodities.StorageDevices {
    private final double usbVersion;

    FlashMemory(String ID, String name, double price, int availableCount, Category category, double weight, String dimensions, double capacity, double usbVersion) {
        super(ID, name, price, availableCount, category, weight, dimensions, capacity);
        this.usbVersion = usbVersion;
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
    public String getID() {
        return super.getID();
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
    public void setAverageRating() {
        super.setAverageRating();
    }

    @Override
    public String getDimensions() {
        return super.getDimensions();
    }

    public double getUsbVersion() {
        return usbVersion;
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
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public double getCapacity() {
        return super.getCapacity();
    }

    @Override
    public String toString() {
        return super.toString() + " USB version: " + usbVersion;
    }
}
