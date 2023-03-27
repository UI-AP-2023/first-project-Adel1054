package comestible;
import category.Category;
import commodity.Commodity;

public class Comestible extends Commodity {
    private final String productionDate;
    private final String expirationDate;
    Comestible(String ID, String name, double price, int availableCount, Category category,String productionDate,String expirationDate){
        super(ID,name,price,availableCount,category);
        this.productionDate=productionDate;
        this.expirationDate=expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getProductionDate() {
        return productionDate;
    }
}
