package commodity.vehicles;

import category.Category;

public class Automobile extends Vehicle {
    private final boolean isAutomatic;
    private final int motorVolume;
    Automobile(String ID, String name, double price, int availableCount, Category category, String companyName, boolean isAutomatic, int motorVolume){
        super(ID,name,price,availableCount,category,companyName);
        this.isAutomatic=isAutomatic;
        this.motorVolume=motorVolume;
    }

    public int getMotorVolume() {
        return motorVolume;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }
}
