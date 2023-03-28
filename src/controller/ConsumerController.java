package controller;

import model.user.consumer.Consumer;
import model.user.consumer.SignupRequest;

import java.util.ArrayList;

public class ConsumerController {
    private final ArrayList<Consumer> consumers;
    private final ArrayList<SignupRequest> signupRequests;
    ConsumerController(){
        consumers=new ArrayList<>();
        signupRequests =new ArrayList<>();
    }
    private void addSignupRequest(String username, String password, String firstname, String surname){
        signupRequests.add(new SignupRequest(username,password,firstname,surname));
    }
    private void addConsumer(SignupRequest request){
        consumers.add(new Consumer(request));
    }

    public ArrayList<Consumer> getConsumers() {
        return consumers;
    }

    public ArrayList<SignupRequest> getSignupRequests() {
        return signupRequests;
    }
}
