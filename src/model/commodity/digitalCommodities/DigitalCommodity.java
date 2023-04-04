package model.commodity.digitalCommodities;

import model.commodity.Category;
import model.commodity.Commodity;
import model.user.consumer.Rating;

import java.util.ArrayList;

public abstract class DigitalCommodity extends Commodity {
    private final double weight;
    private final String dimensions;

    protected DigitalCommodity(String name, double price, int availableCount, double weight, String dimensions) {
        super(name, price, availableCount, Category.DIGITAL);
        this.dimensions = dimensions;
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return super.toString() + " Weight: " + weight + " Dimensions: " + dimensions;
    }
}
