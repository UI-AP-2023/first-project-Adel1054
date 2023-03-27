package commodity.stationery;

import category.Category;

public class Notebook extends StationerySupply {
    private final int numberOfPages;
    private final String pageType;
    Notebook(String ID, String name, double price, int availableCount, Category category,String country, int numberOfPages, String pageType){
        super(ID,name,price,availableCount,category,country);
        this.numberOfPages=numberOfPages;
        this.pageType=pageType;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getPageType() {
        return pageType;
    }
    public String getCountry(){
        return country;
    }
}
