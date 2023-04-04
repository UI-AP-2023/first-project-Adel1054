package model.user.admin;

import model.commodity.Commodity;
import model.user.User;
import model.user.consumer.SignupRequest;

import java.util.ArrayList;

public class Admin extends User {
    private static Admin admin;
    static boolean adminMade = false;

    private Admin(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public static void makeAdmin(){
        admin=new Admin("admin","admin","admin@admin.admin","0992299292");
    }
    public static Admin getAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
