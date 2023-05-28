package com.example.onlineshop.model.user.consumer;

public class SignupRequest {
    private final String username;
    private final String password;
    private final String email;
    private final String phoneNumber;

    public SignupRequest(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Username: " + username +" Email address: " + email + " Phone number: " + phoneNumber;
    }
}
