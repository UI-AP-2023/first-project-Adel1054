package commodity.stationery;

import category.Category;

public class Pencil extends StationerySupply {
    private enum PencilType {
        H2,H,F,B,HB
    }
    private final PencilType pencilType;
    Pencil(String ID, String name, double price, int availableCount, Category category,String country, PencilType pencilType){
        super(ID,name,price,availableCount,category,country);
        this.pencilType=pencilType;
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
    public String getName() {
        return super.getName();
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
    public String getCountry() {
        return super.getCountry();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
    }

    public PencilType getPencilType() {
        return pencilType;
    }

    @Override
    public String toString() {
        return super.toString()+" Pencil type: "+pencilType;
    }
}
