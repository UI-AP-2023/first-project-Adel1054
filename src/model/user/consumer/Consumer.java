package model.user.consumer;

import model.commodity.Commodity;
import model.receipt.Receipt;
import model.user.User;

import java.util.ArrayList;

public class Consumer extends User {
    private final ArrayList<Commodity> cart;
    private final ArrayList<Receipt> shoppingHistory;
    private final ArrayList<CreditCard> creditCards;
    private double balance;

    Consumer(SignupRequest request){
        super(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhoneNumber());
        cart=new ArrayList<>();
        shoppingHistory=new ArrayList<>();
        creditCards=new ArrayList<>();
        balance=0;
    }
}