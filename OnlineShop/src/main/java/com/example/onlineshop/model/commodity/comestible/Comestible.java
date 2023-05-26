package com.example.onlineshop.model.commodity.comestible;


import com.example.onlineshop.model.commodity.Category;
import com.example.onlineshop.model.commodity.Commodity;

public class Comestible extends Commodity {
    private final String productionDate;
    private final String expirationDate;

    public Comestible(String name, double price, int availableCount, String productionDate, String expirationDate) {
        super(name, price, availableCount, Category.COMESTIBLE);
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getProductionDate() {
        return productionDate;
    }

    @Override
    public String toString() {
        return super.toString() + " Production: " + productionDate + "Expiration: " + expirationDate;
    }
}
