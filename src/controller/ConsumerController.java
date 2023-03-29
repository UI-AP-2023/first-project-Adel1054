package controller;

import model.commodity.Commodity;
import model.commodity.comestible.Comestible;
import model.commodity.digitalCommodities.FlashMemory;
import model.commodity.digitalCommodities.PC;
import model.commodity.digitalCommodities.SSD;
import model.commodity.stationery.Notebook;
import model.commodity.stationery.Pen;
import model.commodity.stationery.Pencil;
import model.commodity.vehicles.Automobile;
import model.commodity.vehicles.Bicycle;
import model.user.consumer.*;

import java.util.ArrayList;

public class ConsumerController {
    private final ArrayList<Consumer> consumers;
    private final ArrayList<SignupRequest> signupRequests;
    private final ArrayList<CommentRequest> commentRequests;
    private final ArrayList<Comment> comments;
    private final ArrayList<Commodity> commodities;
    public ConsumerController() {
        consumers = new ArrayList<>();
        signupRequests = new ArrayList<>();
        commentRequests = new ArrayList<>();
        comments = new ArrayList<>();
        commodities=new ArrayList<>();
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

    public void changePassword(String username, String password, String newPassword) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username) && consumer.getPassword().equals(password)) {
                consumer.setPassword(newPassword);
            }
        }
    }

    public void changeEmail(String username, String password, String newEmail) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username) && consumer.getPassword().equals(password)) {
                consumer.setEmail(newEmail);
            }
        }
    }

    public void changePhoneNumber(String username, String password, String newPhoneNumber) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username) && consumer.getPassword().equals(password)) {
                consumer.setPhoneNumber(newPhoneNumber);
            }
        }
    }

    public void addComment(CommentRequest commentRequest) {
        String username = commentRequest.getUsername();
        boolean userHasBought = false;
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                for (Commodity commodity : consumer.getCommoditiesBought()) {
                    if (commodity.getID().equals(commentRequest.getCommodityID())) {
                        userHasBought = true;
                        break;
                    }
                }
                consumer.getComments().add(new Comment(commentRequest.getCommodityID(), commentRequest.getText(), userHasBought, consumer));
                break;
            }
        }
    }

    public void addCommentRequest(String commodityID, String username, String text) {
        commentRequests.add(new CommentRequest(commodityID, username, text));
    }

    public void addCommodity(String username, Commodity commodity) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                consumer.getCommoditiesBought().add(commodity);
                break;
            }
        }
    }

    public void addCreditCard(String username, String cardNumber, String CVV2, String password) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                consumer.getCreditCards().add(new CreditCard(cardNumber, CVV2, password));
                break;
            }
        }
    }

    public void addRating(String username, int userRating, Commodity commodity) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                consumer.getRatings().add(new Rating(userRating, commodity));
            }
        }
    }

    public void addToCart(String username, Commodity commodity) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                consumer.getCart().add(commodity);
                break;
            }
        }
    }

    public void changeAccBalance(String username, double change) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                consumer.changeBalance(change);
            }
        }
    }

    public String getCommoditiesBought(String username, int page) {
        StringBuilder commodities = new StringBuilder();
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                if (consumer.getCommoditiesBought().size() >= (page - 1) * 10) {
                    int row=1;
                    if (consumer.getCommoditiesBought().size() >= page  * 10) {
                        for (int i = (page - 1) * 10; i < page * 10; i++) {
                            commodities.append(row++);
                            commodities.append(".");
                            commodities.append(consumer.getCommoditiesBought().get(i).toString());
                            commodities.append("\n");
                        }
                    } else {
                        for (int i = (page - 1) * 10; i < consumer.getCommoditiesBought().size(); i++) {
                            commodities.append(row++);
                            commodities.append(".");
                            commodities.append(consumer.getCommoditiesBought().get(i).toString());
                            commodities.append("\n");
                        }
                    }
                }
            }
        }
        return commodities.toString();
    }
    public String getCShoppingHistory(String username, int page) {
        StringBuilder commodities = new StringBuilder();
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                if (consumer.getShoppingHistory().size() >= (page - 1) * 10) {
                    int row=1;
                    if (consumer.getShoppingHistory().size() >= page  * 10) {
                        for (int i = (page - 1) * 10; i < page * 10; i++) {
                            commodities.append(row++);
                            commodities.append(".");
                            commodities.append(consumer.getShoppingHistory().get(i).toString());
                            commodities.append("\n");
                        }
                    } else {
                        for (int i = (page - 1) * 10; i < consumer.getShoppingHistory().size(); i++) {
                            commodities.append(row++);
                            commodities.append(".");
                            commodities.append(consumer.getCommoditiesBought().get(i).toString());
                            commodities.append("\n");
                        }
                    }
                }
            }
        }
        return commodities.toString();
    }

    public void addComestible(String name, double price, int availableCount, String productionDate, String expirationDate) {
        commodities.add(new Comestible(name, price, availableCount, productionDate, expirationDate));
        Commodity.addToComestibleCount();
    }

    public void addFlashMemory(String name, double price, int availableCount, double weight, String dimensions, int capacity, double usbVersion) {
        commodities.add(new FlashMemory(name, price, availableCount, weight, dimensions, capacity, usbVersion));
        Commodity.addToDigitalCount();
    }

    public void addPC(String name, double price, int availableCount, double weight, String dimensions, int ramCapacity, String cpuType) {
        commodities.add(new PC(name, price, availableCount, weight, dimensions, ramCapacity, cpuType));
        Commodity.addToDigitalCount();
    }

    public void addSSD(String name, double price, int availableCount, double weight, String dimensions, int capacity, double readSpeed, double writeSpeed) {
        commodities.add(new SSD(name, price, availableCount, weight, dimensions, capacity, readSpeed, writeSpeed));
        Commodity.addToDigitalCount();
    }

    public void addNotebook(String name, double price, int availableCount, String country, int numberOfPages, String pageType) {
        commodities.add(new Notebook(name, price, availableCount, country, numberOfPages, pageType));
        Commodity.addToStationeryCount();
    }

    public void addPen(String name, double price, int availableCount, String country, String colour) {
        commodities.add(new Pen(name, price, availableCount, country, colour));
        Commodity.addToStationeryCount();
    }

    public void addPencil(String name, double price, int availableCount, String country, Pencil.PencilType pencilType) {
        commodities.add(new Pencil(name, price, availableCount, country, pencilType));
        Commodity.addToStationeryCount();
    }

    public void addAutomobile(String name, double price, int availableCount, String companyName, boolean isAutomatic, int motorVolume) {
        commodities.add(new Automobile(name, price, availableCount, companyName, isAutomatic, motorVolume));
        Commodity.addToVehicleCount();
    }

    public void addBicycle(String name, double price, int availableCount, String companyName, Bicycle.BicycleType bicycleType) {
        commodities.add(new Bicycle(name, price, availableCount, companyName, bicycleType));
        Commodity.addToVehicleCount();
    }

    public void removeCommodity(Commodity commodity) {
        commodities.remove(commodity);
    }

    public void changeCommodityName(String ID, String newName) {
        for (Commodity commodity : commodities) {
            if (commodity.getID().equals(ID)) {
                commodity.setName(newName);
            }
        }
    }

    public void changeCommodityPrice(String ID, double newPrice) {
        for (Commodity commodity : commodities) {
            if (commodity.getID().equals(ID)) {
                commodity.setPrice(newPrice);
            }
        }
    }

    public void changeCommodityAvailableCount(String ID, int newAvailableCount) {
        for (Commodity commodity : commodities) {
            if (commodity.getID().equals(ID)) {
                commodity.setAvailableCount(newAvailableCount);
            }
        }
    }
    public String getRatings(String ID,int page){
        page--;
        StringBuilder ratings=new StringBuilder();
        for (Commodity commodity:commodities){
            if(commodity.getID().equals(ID)){
                if(commodity.getRatings().size()>=page*10){
                    if(commodity.getRatings().size()>=(page+1)*10){
                        for (int i=page*10;i<(page+1)*10;i++){
                            ratings.append(commodity.getRatings().get(i).toString());
                            ratings.append("\n");
                        }
                    }
                    else {
                        for(int i=page*10;i<(page+1)*10;i++){
                            ratings.append(commodity.getRatings().get(i).toString());
                            ratings.append("\n");
                        }
                    }
                }
            }
        }
        return ratings.toString();
    }
}
