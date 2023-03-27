package commodity.digitalCommodities;

import category.Category;
import commodity.digitalCommodities.DigitalCommodity;

public class PC extends DigitalCommodity {
    private final int ramCapacity;
    private final String cpuType;
    PC(String ID, String name, double price, int availableCount, Category category, double weight, String dimensions,int ramCapacity,String cpuType){
        super(ID,name,price,availableCount,category,weight,dimensions);
        this.cpuType=cpuType;
        this.ramCapacity=ramCapacity;
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
    public String getDimensions() {
        return super.getDimensions();
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
    public String getID() {
        return super.getID();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public String getCpuType() {
        return cpuType;
    }

    @Override
    public String toString() {
        return super.toString()+" Ram capacity: "+ramCapacity+" CPU type: "+cpuType;
    }
}
