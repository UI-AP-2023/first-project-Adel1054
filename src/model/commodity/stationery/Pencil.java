package model.commodity.stationery;

import model.commodity.Category;
import model.user.consumer.Rating;

import java.util.ArrayList;

public class Pencil extends StationerySupply {
    public enum PencilType {
        H2, H, F, B, HB
    }

    private final PencilType pencilType;

    public Pencil(String name, double price, int availableCount, String country, PencilType pencilType) {
        super(name, price, availableCount, country);
        this.pencilType = pencilType;
    }

    public PencilType getPencilType() {
        return pencilType;
    }

    @Override
    public String toString() {
        return super.toString() + " Pencil type: " + pencilType;
    }
}
