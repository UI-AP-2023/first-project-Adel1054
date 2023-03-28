package model.commodity.digitalCommodities;

import model.commodity.Category;
import model.user.consumer.Rating;

import java.util.ArrayList;

public class FlashMemory extends model.commodity.digitalCommodities.StorageDevices {
    private final double usbVersion;

    public FlashMemory(String name, double price, int availableCount, double weight, String dimensions, double capacity, double usbVersion) {
        super(name, price, availableCount, weight, dimensions, capacity);
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
    public int getAvailableCount() {
        return super.getAvailableCount();
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
