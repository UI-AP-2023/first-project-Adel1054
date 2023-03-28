package model.user.consumer;

public class SignupRequest {
    private final String username;
    private final String password;
    private final String email;
    private final String phoneNumber;
    private boolean isPermitted;
    SignupRequest(String username,String password,String firstname,String surname){
        this.username=username;
        this.password=password;
        this.email =firstname;
        this.phoneNumber =surname;
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

    public void setPermitted() {
        isPermitted = true;
    }

    @Override
    public String toString() {
        return "Username: "+username+"\n"+"Full name: "+ email +" "+ phoneNumber;
    }
}
