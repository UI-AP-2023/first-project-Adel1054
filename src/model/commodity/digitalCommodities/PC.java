package model.commodity.digitalCommodities;

import model.commodity.Category;
import model.user.consumer.Rating;

import java.util.ArrayList;

public class PC extends DigitalCommodity {
    private final int ramCapacity;
    private final String cpuType;

    public PC(String name, double price, int availableCount, double weight, String dimensions, int ramCapacity, String cpuType) {
        super(name, price, availableCount, weight, dimensions);
        this.cpuType = cpuType;
        this.ramCapacity = ramCapacity;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public String getCpuType() {
        return cpuType;
    }

    @Override
    public String toString() {
        return super.toString() + " Ram capacity: " + ramCapacity + " CPU type: " + cpuType;
    }
}
