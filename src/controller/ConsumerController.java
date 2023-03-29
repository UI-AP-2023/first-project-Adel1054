package controller;

import model.commodity.Commodity;
import model.user.consumer.Comment;
import model.user.consumer.CommentRequest;
import model.user.consumer.Consumer;
import model.user.consumer.SignupRequest;

import java.util.ArrayList;

public class ConsumerController {
    private final ArrayList<Consumer> consumers;
    private final ArrayList<SignupRequest> signupRequests;
    private final ArrayList<CommentRequest> commentRequests;
    private final ArrayList<Comment> comments;
    public ConsumerController() {
        consumers = new ArrayList<>();
        signupRequests = new ArrayList<>();
        commentRequests=new ArrayList<>();
        comments=new ArrayList<>();
    }

    public void addSignupRequest(String username, String password, String firstname, String surname) {
        signupRequests.add(new SignupRequest(username, password, firstname, surname));
    }

    public void addConsumer(SignupRequest request) {
        consumers.add(new Consumer(request));
    }

    public ArrayList<Consumer> getConsumers() {
        return consumers;
    }


    public ArrayList<SignupRequest> getSignupRequests() {
        return signupRequests;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<CommentRequest> getCommentRequests() {
        return commentRequests;
    }

    public void changeUsername(String username, String password, String newUsername) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username) && consumer.getPassword().equals(password)) {
                consumer.setUsername(newUsername);
            }
        }
    }
    public void changePassword(String username, String password,String newPassword){
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username) && consumer.getPassword().equals(password)) {
                consumer.setPassword(newPassword);
            }
        }
    }
    public void changeEmail(String username, String password,String newEmail){
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username) && consumer.getPassword().equals(password)) {
                consumer.setEmail(newEmail);
            }
        }
    }
    public void changePhoneNumber(String username, String password,String newPhoneNumber){
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username) && consumer.getPassword().equals(password)) {
                consumer.setPhoneNumber(newPhoneNumber);
            }
        }
    }
    /*public void addComment(CommentRequest commentRequest){
        String username=commentRequest.getUsername();
        for(Consumer consumer:consumers){
            if(consumer.getUsername().equals(username)){
                for (Commodity commodity)
                consumer.getComments().add(new Comment(commentRequest.getCommodityID(),commentRequest.getText()))
            }
        }
    }*/
}
