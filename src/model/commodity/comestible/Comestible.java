package model.commodity.comestible;
import model.category.Category;
import model.commodity.Commodity;

public class Comestible extends Commodity {
    private final String productionDate;
    private final String expirationDate;
    Comestible(String ID, String name, double price, int availableCount, Category category,String productionDate,String expirationDate){
        super(ID,name,price,availableCount,category);
        this.productionDate=productionDate;
        this.expirationDate=expirationDate;
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
    public String getID() {
        return super.getID();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setAverageRating() {
        super.setAverageRating();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getProductionDate() {
        return productionDate;
    }

    @Override
    public String toString() {
        return super.toString()+" Production: "+productionDate+"\nExpiration: "+expirationDate;
    }
}
