package com.example.onlineshop.model.user.consumer;


import com.example.onlineshop.model.commodity.Commodity;
import com.example.onlineshop.model.discount.DiscountCode;
import com.example.onlineshop.model.user.User;

import java.util.ArrayList;

public class Consumer extends User {
    private final ArrayList<Commodity> cart;
    private final ArrayList<Double> cartPrices;
    private final ArrayList<Receipt> shoppingHistory;
    private final ArrayList<Rating> ratings;
    private final ArrayList<Commodity> commoditiesBought;
    private final ArrayList<Comment> comments;
    private double balance;
    private final ArrayList<DiscountCode> discountCodes;
    private final ArrayList<DiscountCode> activatedDiscountCodes;

    public Consumer(SignupRequest request) {
        super(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhoneNumber());
        cart = new ArrayList<>();
        cartPrices=new ArrayList<>();
        shoppingHistory = new ArrayList<>();
        comments=new ArrayList<>();
        commoditiesBought=new ArrayList<>();
        ratings=new ArrayList<>();
        discountCodes=new ArrayList<>();
        activatedDiscountCodes=new ArrayList<>();
        balance = 0;
    }

    public ArrayList<Receipt> getShoppingHistory() {
        return shoppingHistory;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Commodity> getCart() {
        return cart;
    }

    public void changeBalance(double change) {
        balance += change;
    }

    public ArrayList<Commodity> getCommoditiesBought() {
        return commoditiesBought;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public ArrayList<DiscountCode> getDiscountCodes() {
        return discountCodes;
    }

    public ArrayList<DiscountCode> getActivatedDiscountCodes() {
        return activatedDiscountCodes;
    }

    public ArrayList<Double> getCartPrices() {
        return cartPrices;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumber of purchases made: " + shoppingHistory.size()+" Total commodities bought: "+commoditiesBought.size() + " Current balance: " + balance+"$"+" discount codes: "+discountCodes.size();
    }
}