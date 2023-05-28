package com.example.onlineshop.model.commodity.digitalCommodities;



public abstract class StorageDevices extends DigitalCommodity {
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