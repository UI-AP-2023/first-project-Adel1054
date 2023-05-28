package com.example.onlineshop.view.sceneControllers;

import com.example.onlineshop.Main;
import com.example.onlineshop.model.commodity.Commodity;
import com.example.onlineshop.model.user.consumer.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    private static final ArrayList<Consumer> consumers = new ArrayList<>();
    private static final ArrayList<Commodity> commodities = new ArrayList<>();
    private static final ArrayList<Comment> comments = new ArrayList<>();
    private static final ArrayList<SignupRequest> signupRequests = new ArrayList<>();
    private static final ArrayList<CommentRequest> commentRequests = new ArrayList<>();
    private static final ArrayList<ChargeRequest> chargeRequests = new ArrayList<>();
    private static final ArrayList<String> usernames = new ArrayList<>();
    private static final ArrayList<String> phoneNumbers = new ArrayList<>();
    private static final ArrayList<String> emails = new ArrayList<>();
    public static ArrayList<String> getUsernames() {
        return usernames;
    }

    public static ArrayList<String> getEmails() {
        return emails;
    }

    public static ArrayList<ChargeRequest> getChargeRequests() {
        return chargeRequests;
    }

    public static ArrayList<Commodity> getCommodities() {
        return commodities;
    }

    public static ArrayList<Consumer> getConsumers() {
        return consumers;
    }

    public static ArrayList<SignupRequest> getSignupRequests() {
        return signupRequests;
    }

    public static ArrayList<Comment> getComments() {
        return comments;
    }

    public static ArrayList<CommentRequest> getCommentRequests() {
        return commentRequests;
    }

    public static ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }
    @FXML
    private Button loginButton;

    @FXML
    private Button seeCommodities_btn;

    @FXML
    void admin_clicked(ActionEvent event) {

    }

    @FXML
    void login_clicked(ActionEvent event) {

    }

    @FXML
    void seeCommodities_clicked(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("commodities-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void signup_clicked(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("signup-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}