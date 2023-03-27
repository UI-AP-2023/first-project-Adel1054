package commodity.digitalCommodities;

import category.Category;

public class StorageDevices extends DigitalCommodity {
    protected final double capacity;
    StorageDevices(String ID, String name, double price, int availableCount, Category category, double weight, String dimensions,double capacity){
        super(ID,name,price,availableCount,category,weight,dimensions);
        this.capacity=capacity;
    }

    @Override
    public double getAverageRating() {
        return super.getAverageRating();
    }

    @Override
    public String getDimensions() {
        return super.getDimensions();
    }

    @Override
    public Category getCategory() {
        return super.getCategory();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getID() {
        return super.getID();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return super.toString()+" Capacity: "+capacity;
    }
}