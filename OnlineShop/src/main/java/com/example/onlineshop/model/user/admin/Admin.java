package com.example.onlineshop.model.user.admin;


import com.example.onlineshop.model.user.User;

public class Admin extends User {
    private static Admin admin;
    static boolean adminMade = false;

    private Admin(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
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
