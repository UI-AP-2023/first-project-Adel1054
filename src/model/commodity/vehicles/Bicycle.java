package commodity.vehicles;

import category.Category;

public class Bicycle extends Vehicle {
    enum BicycleType{
        MOUNTAIN,ROAD,CITY,HYBRID
    }
    private final BicycleType bicycleType;
    Bicycle(String ID, String name, double price, int availableCount, Category category, String companyName, BicycleType bicycleType){
        super(ID,name,price,availableCount,category,companyName);
        this.bicycleType=bicycleType;
    }

    @Override
    public double getAverageRating() {
        return super.getAverageRating();
    }

    @Override
    public Category getCategory() {
        return super.getCategory();
    }

    @Override
    public String getID() {
        return super.getID();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
    }

    @Override
    public String getCompanyName() {
        return super.getCompanyName();
    }

    public BicycleType getBicycleType() {
        return bicycleType;
    }

    @Override
    public String toString() {
        return super.toString()+" Bicycle type: "+bicycleType;
    }
}
