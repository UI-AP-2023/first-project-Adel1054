package controller;

import model.commodity.Category;
import model.commodity.Commodity;
import model.user.consumer.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsumerController {
    private final ArrayList<Consumer> consumers;
    private final ArrayList<Comment> comments;
    private final ArrayList<Commodity> commodities;
    private final ArrayList<SignupRequest> signupRequests;
    private final ArrayList<CommentRequest> commentRequests;
    private final ArrayList<ChargeRequest> chargeRequests;

    public ConsumerController(ArrayList<Consumer> consumers, ArrayList<SignupRequest> signupRequests, ArrayList<CommentRequest> commentRequests, ArrayList<Comment> comments, ArrayList<Commodity> commodities, ArrayList<ChargeRequest> chargeRequests) {
        this.consumers = consumers;
        this.signupRequests = signupRequests;
        this.commentRequests = commentRequests;
        this.comments = comments;
        this.commodities = commodities;
        this.chargeRequests = chargeRequests;
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

    public void addCommentRequest(Commodity commodity, Consumer consumer, String text) {
        commentRequests.add(new CommentRequest(commodity, consumer, text));
    }

    public void addRating(String username, int userRating, Commodity commodity) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                if (consumer.getCommoditiesBought().contains(commodity)) {
                    Rating rating=new Rating(userRating, commodity);
                    consumer.getRatings().add(rating);
                    commodity.getRatings().add(rating);
                    commodity.setAverageRating();
                    break;
                }
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
                break;
            }
        }
    }

    public String getCommoditiesBought(String username, int page) {
        StringBuilder commodities = new StringBuilder();
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                if (consumer.getCommoditiesBought().size() >= (page - 1) * 10) {
                    int row = (page - 1) * 10 + 1;
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
                break;
            }
        }
        return commodities.toString();
    }

    public String getShoppingHistory(String username, int page) {
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
                            commodities.append(consumer.getShoppingHistory().get(i).toString());
                            commodities.append("\n");
                        }
                    }
                }
                break;
            }
        }
        return commodities.toString();
    }

    public String getCart(String username, int page) {
        StringBuilder commodities = new StringBuilder();
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                if (consumer.getCart().size() >= (page - 1) * 10) {
                    int row = (page - 1) * 10 + 1;
                    if (consumer.getCart().size() >= page * 10) {
                        for (int i = (page - 1) * 10; i < page * 10; i++) {
                            commodities.append(row++);
                            commodities.append(".");
                            commodities.append(consumer.getCart().get(i).toString());
                            commodities.append("\n");
                        }
                    } else {
                        for (int i = (page - 1) * 10; i < consumer.getCart().size(); i++) {
                            commodities.append(row++);
                            commodities.append(".");
                            commodities.append(consumer.getCart().get(i).toString());
                            commodities.append("\n");
                        }
                    }
                }
                break;
            }
        }
        return commodities.toString();
    }

    public boolean buyCommodities(String username) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                double totalPrice = 0;
                for (Commodity commodity : consumer.getCart()) {
                    totalPrice += commodity.getPrice();
                }
                if (consumer.getBalance() >= totalPrice) {
                    for (Commodity commodity : consumer.getCart()) {
                        consumer.getCommoditiesBought().add(commodity);
                        commodity.changeAvailableCount(-1);
                    }
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public void chargeRequest(String username, CreditCard creditCard, double amountCharged) {
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                chargeRequests.add(new ChargeRequest(consumer, amountCharged, creditCard));
                break;
            }
        }
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
            if (commodity.getPrice() <= price2 && commodity.getPrice() >= price1) {
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
        Pattern pattern = Pattern.compile(fragment);
        for (Commodity commodity : commodities) {
            Matcher matcher = pattern.matcher(commodity.getName());
            if (matcher.find()) {
                filteredCommodities.add(commodity);
            }
        }
        return filteredCommodities;
    }

    public int getCommodityCount() {
        return commodities.size();
    }

    public String showCommodities(int page, ArrayList<Commodity> commodities) {
        StringBuilder commoditiesList = new StringBuilder();
        if (commodities.size() >= (page - 1) * 10) {
            int number = (page - 1) * 10 + 1;
            if (commodities.size() >= page * 10) {
                for (int i = (page - 1) * 10; i < page * 10; i++) {
                    commoditiesList.append(number++).append(".").append(commodities.get(i)).append("\n");
                }
            } else {
                for (int i = (page - 1) * 10; i < commodities.size(); i++) {
                    commoditiesList.append(number++).append(".").append(commodities.get(i)).append("\n");
                }
            }
        }
        return commoditiesList.toString();
    }

    public String commodityPage(String commodityID) {
        StringBuilder page = new StringBuilder();
        for (Commodity commodity : commodities) {
            if (commodity.getID().equals(commodityID)) {
                page.append(commodity).append("\n");
                if (commodity.getComments().size() > 4) {
                    for (int i = 0; i < 5; i++) {
                        page.append(commodity.getComments().get(i));
                    }
                } else {
                    for (int i = 0; i < commodity.getComments().size(); i++) {
                        page.append(commodity.getComments().get(i));
                    }
                }
                break;
            }
        }
        return page.toString();
    }

    public ArrayList<Commodity> getCommodities() {
        return commodities;
    }

    public String getRatingsOfCommodity(String ID, int page) {
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

    public String commoditiesBought(Consumer consumer) {
        StringBuilder commodities = new StringBuilder();
        int number = 1;
        for (Commodity commodity : consumer.getCommoditiesBought()) {
            commodities.append(number).append(".").append(commodity).append("\n");
        }
        return commodities.toString();
    }
}
