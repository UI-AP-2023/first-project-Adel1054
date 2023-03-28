package controller;

import model.commodity.Commodity;

import java.util.ArrayList;

public class CommodityController {
    private final ArrayList<Commodity> commodities;

    private void addCommodity(Commodity commodity) {
        commodities.add(commodity);
    }

    private void removeCommodity(Commodity commodity) {
        commodities.remove(commodity);
    }

    CommodityController() {
        commodities = new ArrayList<>();
    }
}
