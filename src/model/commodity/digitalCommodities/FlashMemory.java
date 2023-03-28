package model.commodity.digitalCommodities;

import model.category.Category;

public class FlashMemory extends model.commodity.digitalCommodities.StorageDevices {
    private final double usbVersion;
    FlashMemory(String ID, String name, double price, int availableCount, Category category, double weight, String dimensions, double capacity,double usbVersion){
        super(ID,name,price,availableCount,category,weight,dimensions,capacity);
        this.usbVersion=usbVersion;
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
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
    }

    @Override
    public String getDimensions() {
        return super.getDimensions();
    }

    public double getUsbVersion() {
        return usbVersion;
    }

    @Override
    public String toString() {
        return super.toString()+" USB version: "+usbVersion;
    }
}
