package controller;

import model.commodity.Category;
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
import java.util.regex.Pattern;

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
        commodities = new ArrayList<>();
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
                    int row = 1;
                    if (consumer.getCommoditiesBought().size() >= page * 10) {
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
                    int row = 1;
                    if (consumer.getShoppingHistory().size() >= page * 10) {
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

    public String getCommodities(ArrayList<Commodity> commodities, int page) {
        StringBuilder commodities1 = new StringBuilder();
        if (commodities.size() >= (page - 1) * 10) {
            int row = 1;
            if (commodities.size() >= page * 10) {
                for (int i = (page - 1) * 10; i < page * 10; i++) {
                    commodities1.append(row++);
                    commodities1.append(".");
                    commodities1.append(commodities.get(i).toString());
                    commodities1.append("\n");
                }
            } else {
                for (int i = (page - 1) * 10; i < commodities.size(); i++) {
                    commodities1.append(row++);
                    commodities1.append(".");
                    commodities1.append(commodities.get(i).toString());
                    commodities1.append("\n");
                }
            }
        }
        return commodities1.toString();
    }

    public ArrayList<Commodity> filterByCategory(Category category, ArrayList<Commodity> commodities) {
        ArrayList<Commodity> filteredCommodities = new ArrayList<>();
        for (Commodity commodity : commodities) {
            if (commodity.getCategory().equals(category)) {
                filteredCommodities.add(commodity);
            }
        }
        return filteredCommodities;
    }

    public ArrayList<Commodity> filterByRating(double rating1, double rating2, ArrayList<Commodity> commodities) {
        ArrayList<Commodity> filteredCommodities = new ArrayList<>();
        for (Commodity commodity : commodities) {
            if (commodity.getAverageRating() <= rating2 && commodity.getAverageRating() >= rating1) {
                filteredCommodities.add(commodity);
            }
        }
        return filteredCommodities;
    }

    public ArrayList<Commodity> filterByPrice(double price1, double price2, ArrayList<Commodity> commodities) {
        ArrayList<Commodity> filteredCommodities = new ArrayList<>();
        for (Commodity commodity : commodities) {
            if (commodity.getAverageRating() <= price2 && commodity.getAverageRating() >= price1) {
                filteredCommodities.add(commodity);
            }
        }
        return filteredCommodities;
    }

    public ArrayList<Commodity> filterByAvailability(ArrayList<Commodity> commodities) {
        ArrayList<Commodity> filteredCommodities = new ArrayList<>();
        for (Commodity commodity : commodities) {
            if (commodity.getAvailableCount() != 0) {
                filteredCommodities.add(commodity);
            }
        }
        return filteredCommodities;
    }

    public ArrayList<Commodity> filterByNameFragment(String fragment, ArrayList<Commodity> commodities) {
        ArrayList<Commodity> filteredCommodities = new ArrayList<>();
        for (Commodity commodity : commodities) {
            if (Pattern.matches("\\w" + fragment, "")) {
                filteredCommodities.add(commodity);
            }
        }
        return filteredCommodities;
    }

    public String getRatings(String ID, int page) {
        page--;
        StringBuilder ratings = new StringBuilder();
        for (Commodity commodity : commodities) {
            if (commodity.getID().equals(ID)) {
                if (commodity.getRatings().size() >= page * 10) {
                    if (commodity.getRatings().size() >= (page + 1) * 10) {
                        for (int i = page * 10; i < (page + 1) * 10; i++) {
                            ratings.append(commodity.getRatings().get(i).toString());
                            ratings.append("\n");
                        }
                    } else {
                        for (int i = page * 10; i < (page + 1) * 10; i++) {
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
