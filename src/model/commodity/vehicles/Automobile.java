package model.commodity.vehicles;

import model.commodity.Category;
import model.user.consumer.Rating;

import java.util.ArrayList;

public class Automobile extends Vehicle {
    private final boolean isAutomatic;
    private final int motorVolume;

    public Automobile(String name, double price, int availableCount, String companyName, boolean isAutomatic, int motorVolume) {
        super(name, price, availableCount, companyName);
        this.isAutomatic = isAutomatic;
        this.motorVolume = motorVolume;
    }

    public int getMotorVolume() {
        return motorVolume;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    @Override
    public String toString() {
        return super.toString() + " Motor Volume: " + motorVolume + " Is automatic: " + isAutomatic;
    }
}
