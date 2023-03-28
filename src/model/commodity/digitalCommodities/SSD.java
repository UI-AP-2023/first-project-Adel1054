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
    public double getCapacity() {
        return super.getCapacity();
    }

    public double getWriteSpeed() {
        return writeSpeed;
    }

    public double getReadSpeed() {
        return readSpeed;
    }

    @Override
    public String toString() {
        return super.toString()+" Write speed: "+writeSpeed+" Read speed: "+readSpeed;
    }
}
