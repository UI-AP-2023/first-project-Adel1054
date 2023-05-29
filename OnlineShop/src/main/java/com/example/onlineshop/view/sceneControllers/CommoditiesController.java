package com.example.onlineshop.view.sceneControllers;

import com.example.onlineshop.model.commodity.Category;
import com.example.onlineshop.model.commodity.Commodity;
import com.example.onlineshop.model.commodity.digitalCommodities.FlashMemory;
import com.example.onlineshop.model.commodity.vehicles.Bicycle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CommoditiesController implements Initializable {
//    CommoditiesController(){
//        ArrayList<Commodity> commodityArrayList=new ArrayList<>();
//        int size=MainController.getCommodities().size();
//        page=1;
//        if(size%10==0){
//            pageCount=size/10;
//        }else {
//            pageCount=size/10+1;
//        }
//        for(int i=0;i<Math.min(10,size);i++){
//            commodityArrayList.add(MainController.getCommodities().get(i));
//        }
//        ObservableList<Commodity> commodities= FXCollections.observableArrayList(commodityArrayList);
//        //tableView.setItems(commodities);
//    }
    int page;
    int pageCount;
    @FXML
    private TableColumn<Commodity, Integer> availability_column;

    @FXML
    private TableColumn<Commodity, Double> avg_column;

    @FXML
    private Button back_btn;

    @FXML
    private TableColumn<Commodity, Category> category_column;

    @FXML
    private TableColumn<Commodity, String> id_column;

    @FXML
    private Button last_btn;

    @FXML
    private TableColumn<Commodity, String> name_column;

    @FXML
    private Button next_btn;

    @FXML
    private TableColumn<Commodity, Integer> noComments_column;

    @FXML
    private TableColumn<Commodity, Integer> noRatings_column;

    @FXML
    private TableColumn<Commodity, Double> price_column;

    @FXML
    private TableView<Commodity> tableView;
    ArrayList<Commodity> commodityArrayList=new ArrayList<>(){
        Commodity commodity1=new Bicycle("bike",1000,10,"Saipa", Bicycle.BicycleType.HYBRID);
    };
    ObservableList<Commodity> commodities= FXCollections.observableArrayList(commodityArrayList);

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setItems(commodities);
        commodities.add(new FlashMemory("Flash",100,10,100,"Hello",10,10));
        availability_column.setCellValueFactory(new PropertyValueFactory<>("available"));
        avg_column.setCellValueFactory(new PropertyValueFactory<>("averageRating"));
        category_column.setCellValueFactory(new PropertyValueFactory<>("category"));
        id_column.setCellValueFactory(new PropertyValueFactory<>("ID"));
        noRatings_column.setCellValueFactory(new PropertyValueFactory<>("ratingsCount"));
        noComments_column.setCellValueFactory(new PropertyValueFactory<>("commentsCount"));
        price_column.setCellValueFactory(new PropertyValueFactory<>("price"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
    }
}
