package model.commodity.stationery;

import model.commodity.Category;
import model.user.consumer.Rating;

import java.util.ArrayList;

public class Pen extends StationerySupply {
    private final String colour;

    public Pen(String name, double price, int availableCount, String country, String colour) {
        super(name, price, availableCount, country);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return super.toString() + " Pen colour: " + colour;
    }
}
