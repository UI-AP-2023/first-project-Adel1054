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
import model.user.admin.Admin;
import model.user.consumer.*;

import java.util.ArrayList;

public class AdminController {
    private final Admin admin;
    private final ArrayList<Commodity> commodities;
    private final ArrayList<Consumer> consumers;
    private final ArrayList<Comment> comments;
    private final ArrayList<SignupRequest> signupRequests;
    private final ArrayList<CommentRequest> commentRequests;
    private final ArrayList<ChargeRequest> chargeRequests;

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

    public boolean addConsumer(String username) {
        boolean hasAdded=false;
        for(SignupRequest signupRequest:signupRequests) {
            if(signupRequest.getUsername().equals(username)){
                consumers.add(new Consumer(signupRequest));
                signupRequests.remove(signupRequest);
                hasAdded=true;
                break;
            }
        }
        return hasAdded;
    }
    public boolean denySignupRequest(String username){
        boolean hasDenied=false;
        for (SignupRequest signupRequest:signupRequests){
            if(signupRequest.getUsername().equals(username)){
                signupRequests.remove(signupRequest);
                hasDenied=true;
                break;
            }
        }
        return hasDenied;
    }

    public String getAllComments(int page) {
        StringBuilder comments = new StringBuilder();
        if (this.comments.size() >= (page - 1) * 5) {
            if (this.comments.size() >= page * 5) {
                for (int i = (page - 1) * 5; i < page * 5; i++) {
                    comments.append(this.comments.get(i).toString());
                    comments.append("\n");
                }
            } else {
                for (int i = (page - 1) * 5; i < this.comments.size(); i++) {
                    comments.append(this.comments.get(i).toString());
                    comments.append("\n");
                }
            }
        }
        return comments.toString();
    }

    public boolean addToBalance(String username,double amount) {
        boolean added=false;
        for (ChargeRequest chargeRequest:chargeRequests) {
            if (chargeRequest.getConsumer().getUsername().equals(chargeRequest.getConsumer().getUsername())&&chargeRequest.getAmount()==amount) {
                if (chargeRequest.getCreditCard().getBalance() >= chargeRequest.getAmount()) {
                    chargeRequest.getConsumer().changeBalance(chargeRequest.getAmount());
                    chargeRequest.getCreditCard().changeBalance(-chargeRequest.getAmount());
                    added=true;
                    break;
                }
            }
        }
        return added;
    }

    public boolean addComment(String username,String commodityName) {
        boolean hasAdded =false;
        for(CommentRequest commentRequest:commentRequests){
            if(commentRequest.getConsumer().getUsername().equals(username)&&commentRequest.getCommodity().getName().equals(commodityName)){
                comments.add(new Comment(commentRequest));
                commentRequests.remove(commentRequest);
                hasAdded=true;
                break;
            }
        }
        return hasAdded;
    }
    public boolean denyComment(String username,String commodityName) {
        boolean hasDenied=false;
        for(CommentRequest commentRequest:commentRequests){
            if(commentRequest.getConsumer().getUsername().equals(username)&&commentRequest.getCommodity().getName().equals(commodityName)){
                commentRequests.remove(commentRequest);
                hasDenied=true;
                break;
            }
        }
        return hasDenied;
    }
    public String getConsumers(int page) {
        StringBuilder consumers = new StringBuilder();
        if (this.consumers.size() >= (page - 1) * 5) {
            if (this.consumers.size() >= page * 5) {
                for (int i = (page - 1) * 5; i < page * 5; i++) {
                    consumers.append(this.consumers.get(i));
                    consumers.append("\n");
                }
            } else {
                for (int i = (page - 1) * 5; i < this.consumers.size(); i++) {
                    consumers.append(this.consumers.get(i));
                    consumers.append("\n");
                }
            }
        }
        return consumers.toString();
    }

    public String getSignupRequests(int page) {
        StringBuilder signupRequests = new StringBuilder();
        if (this.signupRequests.size() >= (page - 1) * 10) {
            int number=1;
            if (this.signupRequests.size() >= page * 10) {
                for (int i = (page - 1) * 10; i < page * 10; i++) {
                    signupRequests.append(number++).append(".").append(this.signupRequests.get(i)).append("\n");
                }
            } else {
                for (int i = (page - 1) * 10; i < this.signupRequests.size(); i++) {
                    signupRequests.append(number++).append(".").append(this.signupRequests.get(i)).append("\n");
                }
            }
        }
        return signupRequests.toString();
    }

    public String getCommentRequests(int page) {
        StringBuilder commentRequests = new StringBuilder();
        if (this.commentRequests.size() >= (page - 1) * 10) {
            int number=1;
            if (this.commentRequests.size() >= page * 10) {
                for (int i = (page - 1) * 10; i < page * 10; i++) {
                    commentRequests.append(number++).append(".").append(this.commentRequests.get(i)).append("\n");
                }
            } else {
                for (int i = (page - 1) * 10; i < this.commentRequests.size(); i++) {
                    commentRequests.append(number++).append(".").append(this.commentRequests.get(i)).append("\n");
                }
            }
        }
        return commentRequests.toString();
    }

    public String getChargeRequests(int page) {
        StringBuilder chargeRequests = new StringBuilder();
        if (this.chargeRequests.size() >= (page - 1) * 10) {
            int number=1;
            if (this.chargeRequests.size() >= page * 10) {
                for (int i = (page - 1) * 10; i < page * 10; i++) {
                    chargeRequests.append(number++).append(".").append(this.chargeRequests.get(i)).append("\n");
                }
            } else {
                for (int i = (page - 1) * 10; i < this.chargeRequests.size(); i++) {
                    chargeRequests.append(number++).append(".").append(this.chargeRequests.get(i)).append("\n");
                }
            }
        }
        return chargeRequests.toString();
    }
    public String getCommodities(int page){
        StringBuilder commodities = new StringBuilder();
        if (this.commodities.size() >= (page - 1) * 10) {
            int number=1;
            if (this.commodities.size() >= page * 10) {
                for (int i = (page - 1) * 10; i < page * 10; i++) {
                    commodities.append(number++).append(".").append(this.commodities.get(i)).append("\n");
                }
            } else {
                for (int i = (page - 1) * 10; i < this.commodities.size(); i++) {
                    commodities.append(number++).append(".").append(this.commodities.get(i)).append("\n");
                }
            }
        }
        return commodities.toString();
    }

    public int getConsumerCount() {
        return consumers.size();
    }

    public int getCommentCount() {
        return comments.size();
    }

    public int getCommodityCount() {
        return commodities.size();
    }

    public int getSignupRequestCount() {
        return signupRequests.size();
    }

    public int getCommentRequestCount() {
        return commentRequests.size();
    }

    public int getChargeRequestCount() {
        return chargeRequests.size();
    }

    public AdminController(ArrayList<Consumer> consumers, ArrayList<Commodity> commodities, ArrayList<Comment> comments, ArrayList<SignupRequest> signupRequests, ArrayList<CommentRequest> commentRequests, ArrayList<ChargeRequest> chargeRequests) {
        this.consumers = consumers;
        this.commodities = commodities;
        this.comments = comments;
        this.signupRequests = signupRequests;
        this.commentRequests = commentRequests;
        this.chargeRequests = chargeRequests;
        admin = Admin.initializeAdmin("Adel", "PasSwOrd@", "adelp1054@gmail.com", "09137284754");
    }

}
