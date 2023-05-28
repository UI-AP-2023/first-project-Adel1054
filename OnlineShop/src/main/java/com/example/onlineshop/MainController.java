package com.example.onlineshop;

import com.example.onlineshop.model.commodity.Commodity;
import com.example.onlineshop.model.user.consumer.*;
import com.example.onlineshop.view.controllers.SignupController;
import com.example.onlineshop.view.stages.SignupStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    private final ArrayList<Consumer> consumers = new ArrayList<>();
    private final ArrayList<Commodity> commodities = new ArrayList<>();
    private final ArrayList<Comment> comments = new ArrayList<>();
    private final ArrayList<SignupRequest> signupRequests = new ArrayList<>();
    private final ArrayList<CommentRequest> commentRequests = new ArrayList<>();
    private final ArrayList<ChargeRequest> chargeRequests = new ArrayList<>();
    private final ArrayList<String> usernames = new ArrayList<>();
    private final ArrayList<String> passwords = new ArrayList<>();
    private final ArrayList<String> emails = new ArrayList<>();
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
    void seeCommodities_clicked(ActionEvent event) {

    }

    @FXML
    void signup_clicked(ActionEvent event) throws IOException{
        System.out.println("Hi");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("signup-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}