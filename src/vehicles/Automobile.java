package vehicles;

public class Automobile extends Vehicle{
    private final boolean isAutomatic;
    private final int motorVolume;
    Automobile(String companyName,boolean isAutomatic,int motorVolume){
        super(companyName);
        this.isAutomatic=isAutomatic;
        this.motorVolume=motorVolume;
    }

    public int getMotorVolume() {
        return motorVolume;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }
}
