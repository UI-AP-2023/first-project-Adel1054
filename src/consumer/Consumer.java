package consumer;

import commodity.Commodity;
import receipt.Receipt;

import java.util.ArrayList;

public class Consumer {
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private final ArrayList<Commodity> cart;
    private final ArrayList<Receipt> shoppingHistory;
    private double balance;

    public String getFirstname() {
        return firstname;
    }

    public ArrayList<Commodity> getCart() {
        return cart;
    }

    public ArrayList<Receipt> getShoppingHistory() {
        return shoppingHistory;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    Consumer(String username,String password,String firstname,String surname){
        this.username=username;
        this.password=password;
        this.firstname=firstname;
        this.surname=surname;
        cart=new ArrayList<>();
        shoppingHistory=new ArrayList<>();
        balance=0;
    }
    @Override
    public String toString() {
        return "FullName: "+firstname+" "+surname+" Account balance: "+balance;
    }
}