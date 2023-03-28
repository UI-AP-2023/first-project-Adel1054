package model.user.admin;

import model.commodity.Commodity;
import model.user.User;
import model.user.consumer.SignupRequest;

import java.util.ArrayList;

public class Admin extends User {
    private final ArrayList<Commodity> commodities;
    private final ArrayList<SignupRequest> requests;
    static Admin admin;
    private Admin(String username,String password,String email,String phoneNumber){
        super(username,password,email,phoneNumber);
        requests=new ArrayList<>();
        commodities=new ArrayList<>();
    }

    public ArrayList<Commodity> getCommodities() {
        return commodities;
    }

    public ArrayList<SignupRequest> getRequests() {
        return requests;
    }

}
