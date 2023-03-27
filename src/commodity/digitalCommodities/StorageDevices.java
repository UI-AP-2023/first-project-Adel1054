package commodity.digitalCommodities;

import category.Category;
import commodity.digitalCommodities.DigitalCommodity;

public class StorageDevices extends DigitalCommodity {
    protected double capacity;
    StorageDevices(String ID, String name, double price, int availableCount, Category category, double weight, String dimensions,double capacity){
        super(ID,name,price,availableCount,category,weight,dimensions);
        this.capacity=capacity;
    }
}