package model.user.admin;

import model.commodity.Commodity;
import model.user.User;
import model.user.consumer.SignupRequest;

import java.util.ArrayList;

public class Admin extends User {
    private final ArrayList<Commodity> commodities;
    private final ArrayList<SignupRequest> requests;
    private static Admin admin;
    static boolean adminMade = false;

    private Admin(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
        requests = new ArrayList<>();
        commodities = new ArrayList<>();
    }

    public ArrayList<Commodity> getCommodities() {
        return commodities;
    }

    public ArrayList<SignupRequest> getRequests() {
        return requests;
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

    public static Admin getAdmin() {
        return admin;
    }

    public static void initializeAdmin(String username, String password, String email, String phoneNumber) {
        if (adminMade) {
            return;
        }
        admin = new Admin(username, password, email, phoneNumber);
        adminMade = true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
