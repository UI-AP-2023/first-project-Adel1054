package model.commodity.digitalCommodities;

import model.commodity.Category;
import model.user.consumer.Rating;

import java.util.ArrayList;

public class FlashMemory extends model.commodity.digitalCommodities.StorageDevices {
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
