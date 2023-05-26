package com.example.onlineshop.model.commodity.digitalCommodities;

import com.example.onlineshop.model.commodity.Category;
import com.example.onlineshop.model.commodity.Commodity;
import com.example.onlineshop.model.discount.IDiscount;


public abstract class DigitalCommodity extends Commodity implements IDiscount {
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
    public boolean addDiscountToCommodity(String ID, double percentage, int capacity) {
        if (getID().equals(ID)) {
            setDiscountCap(capacity);
            setDiscount(percentage);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDiscount(String ID) {
        if(getID().equals(ID)){
            setDiscounted(false);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " Weight: " + weight + " Dimensions: " + dimensions;
    }
}
