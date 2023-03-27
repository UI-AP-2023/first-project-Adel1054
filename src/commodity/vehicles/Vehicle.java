package vehicles;

import category.Category;
import commodity.Commodity;

public class Vehicle extends Commodity {
    protected String companyName;
    Vehicle(String ID, String name, double price, int availableCount, Category category,String companyName){
        super(ID,name,price,availableCount,category);
        this.companyName=companyName;
    }
}
