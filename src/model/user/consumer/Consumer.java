package model.user.consumer;

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

    public Consumer(SignupRequest request) {
        super(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhoneNumber());
        cart = new ArrayList<>();
        shoppingHistory = new ArrayList<>();
        comments=new ArrayList<>();
        commoditiesBought=new ArrayList<>();
        ratings=new ArrayList<>();
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

    @Override
    public String toString() {
        return super.toString() + "\nNumber of purchases made: " + shoppingHistory.size() + " Current balance: " + balance+"$";
    }
}