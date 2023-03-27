package stationery;

public class Notebook extends StationerySupply{
    private final int numberOfPages;
    private final String pageType;
    Notebook(String country,int numberOfPages,String pageType){
        super(country);
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
