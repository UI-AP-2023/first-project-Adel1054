package commodity.vehicles;

import category.Category;

public class Bicycle extends Vehicle {
    enum BicycleType{
        MOUNTAIN,ROAD,CITY,HYBRID
    }
    BicycleType bicycleType;
    Bicycle(String ID, String name, double price, int availableCount, Category category, String companyName, BicycleType bicycleType){
        super(ID,name,price,availableCount,category,companyName);
        this.bicycleType=bicycleType;
    }
}
