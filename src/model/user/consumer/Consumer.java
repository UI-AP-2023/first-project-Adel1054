package model.user.consumer;

import model.commodity.Commodity;
import model.user.User;

import java.util.ArrayList;

public class Consumer extends User {
    private final ArrayList<Commodity> cart;
    private final ArrayList<Receipt> shoppingHistory;
    private final ArrayList<CreditCard> creditCards;
    private double balance;

    public Consumer(SignupRequest request) {
        super(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhoneNumber());
        cart = new ArrayList<>();
        shoppingHistory = new ArrayList<>();
        creditCards = new ArrayList<>();
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

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    public void changeBalance(double change) {
        balance += change;
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumber of commodities bought: " + shoppingHistory.size() + "\nCurrent balance: " + balance;
    }
}