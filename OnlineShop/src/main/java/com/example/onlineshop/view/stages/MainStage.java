package com.example.onlineshop.view.stages;

import com.example.onlineshop.model.commodity.Commodity;
import com.example.onlineshop.model.user.consumer.*;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainStage {
    public Stage getStage() {
        Stage stage = new Stage();
        HBox root = new HBox();
        ArrayList<Consumer> consumers = new ArrayList<>();
        ArrayList<Commodity> commodities = new ArrayList<>();
        ArrayList<Comment> comments = new ArrayList<>();
        ArrayList<SignupRequest> signupRequests = new ArrayList<>();
        ArrayList<CommentRequest> commentRequests = new ArrayList<>();
        ArrayList<ChargeRequest> chargeRequests = new ArrayList<>();
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();
        Button signup_btn = new Button("Signup");
        Button commodities_btn = new Button("Show Commodities");
        Button cLogin_btn = new Button("Consumer Login");
        Button aLogin_btn = new Button("Admin Login");
        root.getChildren().addAll(signup_btn, commodities_btn, cLogin_btn, aLogin_btn);
        Scene scene = new Scene(root, 600, 200);
        Platform.setImplicitExit(false);
        stage.setOnCloseRequest(Event::consume);
        stage.setScene(scene);
        signup_btn.setOnMouseClicked(mouseEvent -> {
            (new SignupStage(consumers, commodities, comments, signupRequests, commentRequests, chargeRequests, usernames
                    , passwords, emails)).getStage().show();
        });
        return stage;
    }

}
