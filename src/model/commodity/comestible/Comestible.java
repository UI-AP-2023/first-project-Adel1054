package model.commodity.comestible;

import model.commodity.Category;
import model.commodity.Commodity;
import model.user.consumer.Rating;

import java.util.ArrayList;

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
