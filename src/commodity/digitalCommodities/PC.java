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

    public int getRamCapacity() {
        return ramCapacity;
    }

    public String getCpuType() {
        return cpuType;
    }
    
}
