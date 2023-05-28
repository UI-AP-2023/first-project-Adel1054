package com.example.onlineshop.model.commodity.stationery;

import com.example.onlineshop.model.discount.IDiscount;

public class Pencil extends StationerySupply implements IDiscount {
    public enum PencilType {
        H2, H, F, B, HB
    }

    private final PencilType pencilType;

    public Pencil(String name, double price, int availableCount, String country, PencilType pencilType) {
        super(name, price, availableCount, country);
        this.pencilType = pencilType;
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

    public PencilType getPencilType() {
        return pencilType;
    }

    @Override
    public String toString() {
        return super.toString() + " Pencil type: " + pencilType;
    }
}
