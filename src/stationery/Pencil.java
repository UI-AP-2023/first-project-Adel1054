package stationery;

public class Pencil extends StationerySupply{
    enum PencilType {
        H2,H,F,B,HB
    }
    private final PencilType pencilType;
    Pencil(String country,PencilType pencilType){
        super(country);
        this.pencilType=pencilType;
    }
    public String getCountry() {
        return country;
    }

    public PencilType getPencilType() {
        return pencilType;
    }
}
