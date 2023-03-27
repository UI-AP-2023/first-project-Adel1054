package commodity.digitalCommodities;

import category.Category;

public class FlashMemory extends commodity.digitalCommodities.StorageDevices {
    private final double usbVersion;
    FlashMemory(String ID, String name, double price, int availableCount, Category category, double weight, String dimensions, double capacity,double usbVersion){
        super(ID,name,price,availableCount,category,weight,dimensions,capacity);
        this.usbVersion=usbVersion;
    }

    public double getUsbVersion() {
        return usbVersion;
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
