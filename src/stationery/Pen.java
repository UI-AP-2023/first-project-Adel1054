package stationery;

public class Pen extends StationerySupply{
    private final String colour;
    Pen(String country,String colour){
        super(country);
        this.colour=colour;
    }
    public String getCountry(){
        return country;
    }
    public String getColour() {
        return colour;
    }
}
