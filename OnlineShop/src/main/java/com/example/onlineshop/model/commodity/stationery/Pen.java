package com.example.onlineshop.model.commodity.stationery;


import com.example.onlineshop.model.discount.IDiscount;

public class Pen extends StationerySupply implements IDiscount {
    private final String colour;

    public Pen(String name, double price, int availableCount, String country, String colour) {
        super(name, price, availableCount, country);
        this.colour = colour;
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

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return super.toString() + " Pen colour: " + colour;
    }
}
