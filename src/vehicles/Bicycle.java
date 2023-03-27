package vehicles;

public class Bicycle extends Vehicle{
    enum BicycleType{
        MOUNTAIN,ROAD,CITY,HYBRID
    }
    BicycleType bicycleType;
    Bicycle(String companyName,BicycleType bicycleType){
        super(companyName);
        this.bicycleType=bicycleType;
    }
}
