package stationery;

import category.Category;
import commodity.Commodity;

public class StationerySupply extends Commodity {
    protected final String country;
    StationerySupply(String ID, String name, double price, int availableCount, Category category,String country){
        super(ID,name,price,availableCount,category);
        this.country=country;
    }
}