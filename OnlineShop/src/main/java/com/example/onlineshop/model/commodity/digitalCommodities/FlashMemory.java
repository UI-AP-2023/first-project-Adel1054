package com.example.onlineshop.model.commodity.digitalCommodities;



public class FlashMemory extends StorageDevices {
    private final double usbVersion;

    public FlashMemory(String name, double price, int availableCount, double weight, String dimensions, int capacity, double usbVersion) {
        super(name, price, availableCount, weight, dimensions, capacity);
        this.usbVersion = usbVersion;
    }

    public double getUsbVersion() {
        return usbVersion;
    }

    @Override
    public String toString() {
        return super.toString() + " USB version: " + usbVersion;
    }
}
