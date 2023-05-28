package com.example.onlineshop.view.stages;

import com.example.onlineshop.controller.ConsumerController;
import com.example.onlineshop.model.commodity.Commodity;
import com.example.onlineshop.model.user.consumer.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.example.onlineshop.exceptions.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SignupStage {
    private final ConsumerController consumerController;
    private final ArrayList<String> phoneNumbers;
    private final ArrayList<String> emails;
    private final ArrayList<String> usernames;

    public SignupStage(ArrayList<Consumer> consumers, ArrayList<Commodity> commodities, ArrayList<Comment> comments, ArrayList<SignupRequest> signupRequests, ArrayList<CommentRequest> commentRequests, ArrayList<ChargeRequest> chargeRequests, ArrayList<String> usernames, ArrayList<String> emails,ArrayList<String> phoneNumbers) {
        consumerController = new ConsumerController(consumers, signupRequests, commentRequests, comments, commodities, chargeRequests,usernames,emails,phoneNumbers);
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
        this.usernames = usernames;
    }

    public Stage getStage() {
        VBox root = new VBox();
        root.setSpacing(20);
        Stage stage = new Stage();
        Button submit_btn = new Button("Submit");
        Button back_btn = new Button("Back");
        Text text=new Text("Enter a unique username: ");
        root.getChildren().add(text);
        TextField info = new TextField("");
        root.getChildren().addAll(info,submit_btn,back_btn);
        StringBuilder username=new StringBuilder();
        StringBuilder password=new StringBuilder();
        StringBuilder email=new StringBuilder();
        StringBuilder phoneNumber=new StringBuilder();
        Scene scene=new Scene(root,400,400);
        root.setStyle("-fx-background-color: lightblue");
        stage.setScene(scene);
        AtomicInteger i=new AtomicInteger(0);
        submit_btn.setOnMouseClicked(mouseEvent -> {
            switch (i.get()) {
                case 0: {
                    try {
                        boolean a = consumerController.checkUsernameT(info.getText());
                        if (a) {
                            username.append(info.getText());
                            i.set(5);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Name successfully submitted");
                            alert.setHeaderText(null);
                            alert.show();
                            text.setText("Enter a password");
                        }
                    } catch (InvalidUsernameException e1) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, e1.getMessage());
                        alert.show();
                    }finally {
                        info.setText("");
                    }
                }
                break;
                case 5: {
                    try {
                        boolean a = consumerController.checkPasswordT(info.getText());
                        if (a) {
                            password.append(info.getText());
                            i.set(10);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Password successfully submitted");
                            alert.setHeaderText(null);
                            alert.show();
                            text.setText("Enter an email");
                        }
                    } catch (InvalidPasswordException e1) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, e1.getMessage());
                        alert.show();
                    }finally {
                        info.setText("");
                    }
                }
                break;
                case 10: {
                    try {
                        boolean a = consumerController.checkEmailT(info.getText());
                        if (a) {
                            email.append(info.getText());
                            i.set(15);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Email successfully submitted");
                            alert.setHeaderText(null);
                            alert.show();
                            text.setText("Enter a phone number");
                        }
                    } catch (InvalidEmailException e1) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, e1.getMessage());
                        alert.show();
                    }finally {
                        info.setText("");
                    }
                }
                break;
                case 15: {
                    try {
                        boolean a = consumerController.checkPhoneNumberT(info.getText());
                        if (a) {
                            phoneNumber.append(info.getText());
                            i.set(20);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Signup request successfully submitted and awaiting confirmation.");
                            alert.setHeaderText(null);
                            consumerController.getSignupRequests().add(new SignupRequest(username.toString(), password.toString(), email.toString(), phoneNumber.toString()));
                            alert.show();
                            stage.close();
                        }
                    } catch (InvalidPhoneNumberException e1) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, e1.getMessage());
                        alert.show();
                    }
                }
                break;
            }
        });
        back_btn.setOnMouseClicked(mouseEvent -> {
            stage.close();
        });
        return stage;
    }
}
