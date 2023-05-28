package com.example.onlineshop.view.sceneControllers;

import com.example.onlineshop.controller.ConsumerController;
import com.example.onlineshop.exceptions.*;
import com.example.onlineshop.model.user.consumer.SignupRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController {
    @FXML
    private Button back_btn;

    @FXML
    private TextField email_txt;

    @FXML
    private TextField password_txt;

    @FXML
    private TextField phone_txt;

    @FXML
    private Button submit_btn;

    @FXML
    private TextField username_txt;

    @FXML
    void back_action(ActionEvent event) {
        Stage stage = (Stage) back_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void submit_action(ActionEvent event) {
        ConsumerController consumerController = new ConsumerController(MainController.getConsumers(), MainController.getSignupRequests(), MainController.getCommentRequests(), MainController.getComments(), MainController.getCommodities(), MainController.getChargeRequests(), MainController.getUsernames(), MainController.getPhoneNumbers(), MainController.getEmails());
        boolean falseInfo = false;
        try {
            consumerController.checkUsernameT(username_txt.getText());
        } catch (InvalidInfoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle(null);
            alert.show();
            falseInfo = true;
        }
        try {
            consumerController.checkPasswordT(password_txt.getText());
        } catch (InvalidInfoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle(null);
            alert.show();
            falseInfo = true;
        }
        try {
            consumerController.checkEmailT(email_txt.getText());
        } catch (InvalidInfoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle(null);
            alert.show();
            falseInfo = true;
        }
        try {
            consumerController.checkPhoneNumberT(phone_txt.getText());
        } catch (InvalidInfoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle(null);
            alert.show();
            falseInfo = true;
        }
        if (!falseInfo) {
            consumerController.getSignupRequests().add(new SignupRequest(username_txt.getText(), password_txt.getText(), email_txt.getText(), phone_txt.getText()));
            (new Alert(Alert.AlertType.INFORMATION,"Request submitted")).show();
            ((Stage)(submit_btn.getScene().getWindow())).close();
            consumerController.getUsernames().add(username_txt.getText());
            MainController.getPhoneNumbers().add(phone_txt.getText());
            consumerController.getEmails().add(email_txt.getText());
        }
    }
}
