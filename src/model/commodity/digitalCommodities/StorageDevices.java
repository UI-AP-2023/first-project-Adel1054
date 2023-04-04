package model.commodity.digitalCommodities;

import model.commodity.Category;
import model.user.consumer.Rating;

import java.util.ArrayList;

public abstract class StorageDevices extends model.commodity.digitalCommodities.DigitalCommodity {
    private final int capacity;

    protected StorageDevices(String name, double price, int availableCount, double weight, String dimensions, int capacity) {
        super(name, price, availableCount, weight, dimensions);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }
    @Override
    public String toString() {
        return super.toString() + " Capacity: " + capacity;
    }
}