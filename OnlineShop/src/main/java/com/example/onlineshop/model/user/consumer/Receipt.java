package com.example.onlineshop.model.user.consumer;


import com.example.onlineshop.model.commodity.Commodity;

import java.util.ArrayList;

public class Receipt {
    private final String ID;
    private final String dateOfPurchase;
    private double sumPaid;
    private final ArrayList<Commodity> commodities;
    static private int receiptCount=1;

    public Receipt(String dateOfPurchase, ArrayList<Commodity> commodities, double sumPaid) {
        ID=IDBuilder();
        this.commodities =new ArrayList<>(commodities);
        commodities.clear();
        this.sumPaid = sumPaid;
        this.dateOfPurchase = dateOfPurchase;
        receiptCount++;
    }

    public String getID() {
        return ID;
    }

    private String getCommodities() {
        StringBuilder commodities=new StringBuilder();
        for (Commodity commodity:this.commodities){
            commodities.append(commodity.toString());
            commodities.append("\n");
        }
        return commodities.toString();
    }
    private String IDBuilder(){
        StringBuilder ID=new StringBuilder();
        int length=String.valueOf(receiptCount).length();
        for(int i=0;i<8-length;i++){
            ID.append("0");
        }
        ID.append(receiptCount);
        return ID.toString();
    }

    public double getSumPaid() {
        return sumPaid;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    @Override
    public String toString() {
        return "ID: "+ID+" Date of purchase: "+dateOfPurchase+" Total payment: "+sumPaid+"\nCommodities:\n"+getCommodities();
    }
}