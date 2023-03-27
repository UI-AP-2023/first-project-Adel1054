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

    @Override
    public double getAverageRating() {
        return super.getAverageRating();
    }

    @Override
    public String getCompanyName() {
        return super.getCompanyName();
    }

    @Override
    public Category getCategory() {
        return super.getCategory();
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

    public int getMotorVolume() {
        return motorVolume;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    @Override
    public String toString() {
        return super.toString()+" Motor Volume: "+ motorVolume+" Is automatic: "+isAutomatic;
    }
}
