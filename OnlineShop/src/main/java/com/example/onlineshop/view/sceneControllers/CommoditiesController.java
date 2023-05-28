package com.example.onlineshop.view.sceneControllers;

import com.example.onlineshop.model.commodity.Commodity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CommoditiesController {
    int page=0;
    @FXML
    private Button back_btn;

    @FXML
    private Button last_btn;

    @FXML
    private Button next_btn;

    @FXML
    private TableView<?> tableView;

    @FXML
    void back_event(ActionEvent event) {
        ((Stage)(back_btn.getScene().getWindow())).close();
    }

    @FXML
    void item_selected(MouseEvent event) {
        Commodity commodity=(Commodity) tableView.getSelectionModel().getSelectedItem();

    }

    @FXML
    void last_event(ActionEvent event) {

    }

    @FXML
    void next_event(ActionEvent event) {

    }
    ObservableList<Commodity> commodities= FXCollections.observableArrayList(MainController.getCommodities());

}
