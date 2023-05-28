package com.example.onlineshop.view.stages;

import com.example.onlineshop.controller.ConsumerController;
import com.example.onlineshop.model.commodity.Category;
import com.example.onlineshop.model.commodity.Commodity;
import com.example.onlineshop.model.user.consumer.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class CommoditiesStage {
    private final ConsumerController consumerController;
    private boolean filterByCategory;
    private boolean filterByRating;
    private boolean filterByAvailability;
    private boolean filterByPrice;
    private boolean filterByNameFragment;
    private final ArrayList<Commodity> cart;
    private final ArrayList<Commodity> commodities;
    private String nameFragment;
    private double priceLow;
    private double priceHigh;
    private double ratingLow;
    private double ratingHigh;
    private Category category;
    public CommoditiesStage(ArrayList<Consumer> consumers, ArrayList<Commodity> commodities, ArrayList<Comment> comments, ArrayList<SignupRequest> signupRequests, ArrayList<CommentRequest> commentRequests, ArrayList<ChargeRequest> chargeRequests, ArrayList<String> usernames, ArrayList<String> emails, ArrayList<String> phoneNumbers,ArrayList<Commodity> cart) {
        consumerController = new ConsumerController(consumers, signupRequests, commentRequests, comments, commodities, chargeRequests,usernames,emails,phoneNumbers);
        this.commodities=commodities;
        filterByCategory=false;
        filterByAvailability=false;
        filterByNameFragment=false;
        filterByPrice=false;
        filterByRating=false;
        nameFragment="";
        category=null;
        this.cart=cart;
    }
    public Stage getStage(){
        Stage stage=new Stage();
        VBox root=new VBox();
        root.setSpacing(10);
        ArrayList<Button> buttons=new ArrayList<>();
        for (int i=0;i<Math.min(commodities.size(),10);i++){
            buttons.set(i,new Button(commodities.get(i).getName()));
            root.getChildren().add(buttons.get(i));
        }
        return stage;
    }
//    private void filters() {
//        System.out.println("1.filter by availability\t2.filter by price\t3.filter by rating\t4.filter by category\t5.filter by name fragment");
//        System.out.println("6.remove availability filter\t7.remove price filter\t8.remove rating filter\t9.remove category filter\t10.remove name filter");
//        String command2 = input.nextLine();
//        switch (command2) {
//            case "1": {
//                filterByAvailability = true;
//            }
//            break;
//            case "2": {
//                filterByPrice = true;
//                System.out.println("Enter the low price: ");
//                priceLow = input.nextInt();
//                System.out.println("Enter the high price: ");
//                priceHigh = input.nextInt();
//            }
//            break;
//            case "3": {
//                filterByRating = true;
//                System.out.println("Enter the low rating: ");
//                ratingLow = input.nextInt();
//                System.out.println("Enter the high rating: ");
//                ratingHigh = input.nextInt();
//            }
//            break;
//            case "4": {
//                filterByCategory = true;
//                while (category == null) {
//                    System.out.println("1.Comestible\t2.Digital\t3.Stationery\t4.Vehicle");
//                    int command3 = input.nextInt();
//                    input.nextLine();
//                    switch (command3) {
//                        case 1: {
//                            category = Category.COMESTIBLE;
//                        }
//                        break;
//                        case 2: {
//                            category = Category.DIGITAL;
//                        }
//                        break;
//                        case 3: {
//                            category = Category.STATIONERY;
//                        }
//                        break;
//                        case 4: {
//                            category = Category.VEHICLE;
//                        }
//                        break;
//                    }
//                }
//            }
//            break;
//            case "5": {
//                filterByNameFragment = true;
//                System.out.println("Enter name fragment: ");
//                nameFragment = input.nextLine();
//            }
//            break;
//            case "6": {
//                filterByAvailability = false;
//            }
//            break;
//            case "7": {
//                filterByPrice = false;
//            }
//            break;
//            case "8": {
//                filterByRating = false;
//            }
//            break;
//            case "9": {
//                filterByCategory = false;
//                category = null;
//            }
//            break;
//            case "10": {
//                filterByNameFragment = false;
//            }
//            break;
//        }
//    }
}
