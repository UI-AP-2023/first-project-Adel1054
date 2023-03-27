package user.admin;

import commodity.Commodity;
import user.User;
import user.consumer.SignupRequest;

import java.util.ArrayList;

public class Admin extends User {
    ArrayList<Commodity> commodities;
    ArrayList<SignupRequest> requests;
    static Admin admin;
    private Admin(String username,String password,String email,String phoneNumber){
        super(username,password,email,phoneNumber);
    }

}
