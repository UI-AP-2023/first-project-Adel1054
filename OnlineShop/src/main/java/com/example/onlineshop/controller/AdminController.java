package com.example.onlineshop.controller;



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
import com.example.onlineshop.model.discount.DiscountCode;
import com.example.onlineshop.model.user.admin.Admin;
import com.example.onlineshop.model.user.consumer.ChargeRequest;
import com.example.onlineshop.model.user.consumer.Comment;
import com.example.onlineshop.model.user.consumer.CommentRequest;
import com.example.onlineshop.model.user.consumer.SignupRequest;
import com.example.onlineshop.model.user.consumer.Consumer;

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
        sortCommodities();
    }

    public void addFlashMemory(String name, double price, int availableCount, double weight, String dimensions, int capacity, double usbVersion) {
        commodities.add(new FlashMemory(name, price, availableCount, weight, dimensions, capacity, usbVersion));
        sortCommodities();
    }

    public void addPC(String name, double price, int availableCount, double weight, String dimensions, int ramCapacity, String cpuType) {
        commodities.add(new PC(name, price, availableCount, weight, dimensions, ramCapacity, cpuType));
        sortCommodities();
    }

    public void addSSD(String name, double price, int availableCount, double weight, String dimensions, int capacity, double readSpeed, double writeSpeed) {
        commodities.add(new SSD(name, price, availableCount, weight, dimensions, capacity, readSpeed, writeSpeed));
        sortCommodities();
    }

    public void addNotebook(String name, double price, int availableCount, String country, int numberOfPages, String pageType) {
        commodities.add(new Notebook(name, price, availableCount, country, numberOfPages, pageType));
        sortCommodities();
    }

    public void addPen(String name, double price, int availableCount, String country, String colour) {
        commodities.add(new Pen(name, price, availableCount, country, colour));
        sortCommodities();
    }

    public void addPencil(String name, double price, int availableCount, String country, Pencil.PencilType pencilType) {
        commodities.add(new Pencil(name, price, availableCount, country, pencilType));
        sortCommodities();
    }

    public void addAutomobile(String name, double price, int availableCount, String companyName, boolean isAutomatic, int motorVolume) {
        commodities.add(new Automobile(name, price, availableCount, companyName, isAutomatic, motorVolume));
        sortCommodities();
    }

    public void addBicycle(String name, double price, int availableCount, String companyName, Bicycle.BicycleType bicycleType) {
        commodities.add(new Bicycle(name, price, availableCount, companyName, bicycleType));
        sortCommodities();
    }

    public void removeCommodity(String commodityID) {
        Commodity removedCommodity=null;
        for(Commodity commodity:commodities){
            if(commodityID.equals(commodity.getID())){
                removedCommodity=commodity;
            }
        }
        commodities.remove(removedCommodity);
    }

    public boolean addConsumer(String username) {
        boolean hasAdded = false;
        for (SignupRequest signupRequest : signupRequests) {
            if (signupRequest.getUsername().equals(username)) {
                consumers.add(new Consumer(signupRequest));
                signupRequests.remove(signupRequest);
                hasAdded = true;
                break;
            }
        }
        return hasAdded;
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

    public boolean addToBalance(String username, double amount) {
        boolean added = false;
        for (ChargeRequest chargeRequest : chargeRequests) {
            if (username.equals(chargeRequest.getConsumer().getUsername()) && chargeRequest.getAmount() == amount) {
                if (chargeRequest.getCreditCard().getBalance() >= chargeRequest.getAmount()) {
                    chargeRequest.getConsumer().changeBalance(chargeRequest.getAmount());
                    chargeRequest.getCreditCard().changeBalance(-chargeRequest.getAmount());
                    chargeRequests.remove(chargeRequest);
                    added = true;
                    break;
                }
            }
        }
        return added;
    }

    public boolean addComment(String username, String commodityName) {
        boolean hasAdded = false;
        for (CommentRequest commentRequest : commentRequests) {
            if (commentRequest.getConsumer().getUsername().equals(username) && commentRequest.getCommodity().getName().equals(commodityName)) {
                Comment comment=new Comment(commentRequest);
                comments.add(comment);
                commentRequest.getCommodity().getComments().add(comment);
                commentRequests.remove(commentRequest);
                hasAdded = true;
                break;
            }
        }
        return hasAdded;
    }

    public boolean denyComment(String username, String commodityName) {
        boolean hasDenied = false;
        for (CommentRequest commentRequest : commentRequests) {
            if (commentRequest.getConsumer().getUsername().equals(username) && commentRequest.getCommodity().getName().equals(commodityName)) {
                commentRequests.remove(commentRequest);
                hasDenied = true;
                break;
            }
        }
        return hasDenied;
    }

    public ArrayList<Commodity> getCommodities() {
        return commodities;
    }

    public String showConsumers(int page) {
        StringBuilder consumers = new StringBuilder();
        if (this.consumers.size() >= (page - 1) * 5) {
            if (this.consumers.size() >= page * 5) {
                for (int i = (page - 1) * 5; i < page * 5; i++) {
                    consumers.append(this.consumers.get(i).toString());
                    consumers.append("\n");
                }
            } else {
                for (int i = (page - 1) * 5; i < this.consumers.size(); i++) {
                    consumers.append(this.consumers.get(i).toString());
                    consumers.append("\n");
                }
            }
        }
        return consumers.toString();
    }

    public String showSignupRequests(int page) {
        StringBuilder signupRequests = new StringBuilder();
        if (this.signupRequests.size() >= (page - 1) * 10) {
            int number = 1;
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

    public String showCommentRequests(int page) {
        StringBuilder commentRequests = new StringBuilder();
        if (this.commentRequests.size() >= (page - 1) * 10) {
            int number = 1;
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

    public String showChargeRequests(int page) {
        StringBuilder chargeRequests = new StringBuilder();
        if (this.chargeRequests.size() >= (page - 1) * 10) {
            int number = 1;
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

    public String showCommodities(int page) {
        StringBuilder commodities = new StringBuilder();
        if (this.commodities.size() >= (page - 1) * 10) {
            int number = 1;
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
    public boolean addDiscountCode(String username,int discountType,double discountPercentage){
        boolean added=false;
        for(Consumer consumer:consumers){
            if(consumer.getUsername().equals(username)){
                consumer.getDiscountCodes().add(new DiscountCode(discountPercentage,discountType));
            }
            added=true;
            break;
        }
        return added;
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

    public Admin getAdmin() {
        return admin;
    }

    public AdminController(ArrayList<Consumer> consumers, ArrayList<Commodity> commodities, ArrayList<Comment> comments, ArrayList<SignupRequest> signupRequests, ArrayList<CommentRequest> commentRequests, ArrayList<ChargeRequest> chargeRequests) {
        this.consumers = consumers;
        this.commodities = commodities;
        this.comments = comments;
        this.signupRequests = signupRequests;
        this.commentRequests = commentRequests;
        this.chargeRequests = chargeRequests;
        Admin.makeAdmin();
        admin=Admin.getAdmin();
    }
    private void sortCommodities(){
        commodities.sort(Commodity::compareTo);
    }
}
