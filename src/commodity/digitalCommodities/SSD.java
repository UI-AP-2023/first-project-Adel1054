package commodity.digitalCommodities;

import category.Category;
import commodity.digitalCommodities.StorageDevices;

public class SSD extends StorageDevices {
    private final double readSpeed;
    private final double writeSpeed;
    SSD(String ID, String name, double price, int availableCount, Category category, double weight, String dimensions, double capacity,double readSpeed,double writeSpeed){
        super(ID,name,price,availableCount,category,weight,dimensions,capacity);
        this.writeSpeed=writeSpeed;
        this.readSpeed=readSpeed;
    }

    public double getReadSpeed() {
        return readSpeed;
    }

    public double getWriteSpeed() {
        return writeSpeed;
    }
    public String getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getAvailableCount(){
        return availableCount;
    }
    public Category getCategory(){
        return category;
    }
    public double getWeight(){
        return weight;
    }
    public String getDimensions(){
        return dimensions;
    }
}
