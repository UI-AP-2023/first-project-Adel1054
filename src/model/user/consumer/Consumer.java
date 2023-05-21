package model.user.consumer;

import model.DiscountCode;
import model.commodity.Commodity;
import model.user.User;

import java.util.ArrayList;

public class Consumer extends User {
    private final ArrayList<Commodity> cart;
    private final ArrayList<Receipt> shoppingHistory;
    private final ArrayList<Rating> ratings;
    private final ArrayList<Commodity> commoditiesBought;
    private final ArrayList<Comment> comments;
    private double balance;
    private final ArrayList<DiscountCode> discountCodes;

    public Consumer(SignupRequest request) {
        super(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhoneNumber());
        cart = new ArrayList<>();
        shoppingHistory = new ArrayList<>();
        comments=new ArrayList<>();
        commoditiesBought=new ArrayList<>();
        ratings=new ArrayList<>();
        discountCodes=new ArrayList<>();
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

    @Override
    public String toString() {
        return super.toString() + "\nNumber of purchases made: " + shoppingHistory.size()+" Total commodities bought: "+commoditiesBought.size() + " Current balance: " + balance+"$";
    }
}