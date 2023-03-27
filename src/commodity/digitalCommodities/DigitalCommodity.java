package commodity.digitalCommodities;

import category.Category;
import commodity.Commodity;

public class DigitalCommodity extends Commodity {
    protected double weight;
    protected String dimensions;
    DigitalCommodity(String ID, String name, double price, int availableCount, Category category,double weight,String dimensions){
        super(ID,name,price,availableCount,category);
        this.dimensions=dimensions;
        this.weight=weight;
    }
}
