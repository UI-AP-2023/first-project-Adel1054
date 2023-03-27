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
    public String getCountry() {
        return country;
    }

    public PencilType getPencilType() {
        return pencilType;
    }
}
