package com.example.onlineshop.view.sceneControllers;

import com.example.onlineshop.model.commodity.Category;
import com.example.onlineshop.model.commodity.Commodity;
import com.example.onlineshop.model.commodity.comestible.Comestible;
import com.example.onlineshop.model.commodity.digitalCommodities.FlashMemory;
import com.example.onlineshop.model.commodity.digitalCommodities.PC;
import com.example.onlineshop.model.commodity.digitalCommodities.SSD;
import com.example.onlineshop.model.commodity.stationery.Notebook;
import com.example.onlineshop.model.commodity.stationery.Pen;
import com.example.onlineshop.model.commodity.stationery.Pencil;
import com.example.onlineshop.model.commodity.vehicles.Automobile;
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
import java.time.LocalDate;
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
    private ObservableList<Commodity> commodities= FXCollections.observableArrayList(MainController.getCommodities());

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

    public ObservableList<Commodity> getCommodities() {
        return commodities;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setItems(commodities);
        commodities.add(new FlashMemory("Sandisk",20,6,15.4,"5cm*1cm",128,3.2));
        commodities.add(new Pen("FaberCastell.7mm",2,5,"USA","Blue"));
        commodities.add(new Bicycle("Domane",200,2,"Trek", Bicycle.BicycleType.HYBRID));
        commodities.add(new Automobile("Genesis Coupe",40000,1,"Hyundai",true,252));
        commodities.add(new Pencil("Panther",1.5,20,"USA", Pencil.PencilType.HB));
        commodities.add(new Notebook("Staedtler",4.5,15,"Germany",150,"Normal paper"));
        commodities.add(new SSD("Samsung870EVO",80,5,70,"11cm*14cm",1000,560,530));
        commodities.add(new PC("MacbookAirM2",1300,3,1000,"13.6 Inches",8,"IntelCoreI7"));
        commodities.add(new Comestible("Bologna sausage",20,8, LocalDate.now().toString(),LocalDate.now().plusDays(7).toString()));
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

/*
Add Pen FaberCastell.7mm 2 5 USA Blue
Add FlashMemory SanDisk 20 6 15.4 5x1 128 3.2
Add Bicycle Domane 200 2 Trek Hybrid
Add Automobile Genesis 40000 1 Hyundai true 252
Add Pencil Panther 1.5 20 USA HB
Add Notebook Staedtler 4.5 15 Germany 150 normalPaper
Add SSD Samsung870EVO 80 5 70 2.5Inches 1000 560 530
Add PC MacBookAirM2 1300 3 1000 13.6Inches 8 intelCoreI7
Add Comestible BolognaSausage 20 8 4/4/2023 8/4/2023
 */
