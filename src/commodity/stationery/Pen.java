package commodity.stationery;

import category.Category;

public class Pen extends StationerySupply {
    private final String colour;
    Pen(String ID, String name, double price, int availableCount, Category category,String country, String colour){
        super(ID,name,price,availableCount,category,country);
        this.colour=colour;
    }
    public String getCountry(){
        return country;
    }
    public String getColour() {
        return colour;
    }
}
