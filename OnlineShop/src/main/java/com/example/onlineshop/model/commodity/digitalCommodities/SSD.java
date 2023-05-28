package com.example.onlineshop.model.commodity.digitalCommodities;



public class SSD extends StorageDevices {
    private final double readSpeed;
    private final double writeSpeed;

    public SSD(String name, double price, int availableCount, double weight, String dimensions, int capacity, double readSpeed, double writeSpeed) {
        super(name, price, availableCount, weight, dimensions, capacity);
        this.writeSpeed = writeSpeed;
        this.readSpeed = readSpeed;
    }

    public double getWriteSpeed() {
        return writeSpeed;
    }

    public double getReadSpeed() {
        return readSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + " Write speed: " + writeSpeed + " Read speed: " + readSpeed;
    }
}
