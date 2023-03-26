package receipt;

import commodity.Commodity;

import java.util.ArrayList;

public class Receipt {
    private final String ID;
    private final String dateOfPurchase;
    private double sumPaid;
    private final ArrayList<Commodity> commodities;
    Receipt(String ID,String dateOfPurchase,ArrayList<Commodity> commodities){
        this.ID=ID;
        this.commodities=commodities;
        sumPaid=0;
        this.dateOfPurchase=dateOfPurchase;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<Commodity> getCommodities() {
        return commodities;
    }

    public double getSumPaid() {
        return sumPaid;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }
}