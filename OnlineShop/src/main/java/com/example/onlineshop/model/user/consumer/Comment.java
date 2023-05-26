package com.example.onlineshop.model.user.consumer;


public class Comment {
    private final Consumer consumer;
    private final String commodityID;
    private String text;
    private final boolean userHasBought;

    public Comment(CommentRequest commentRequest) {
        consumer = commentRequest.getConsumer();
        commodityID = commentRequest.getCommodity().getID();
        text = commentRequest.getText();
        if (commentRequest.getConsumer().getCommoditiesBought().contains(commentRequest.getCommodity())) {
            userHasBought = true;
        } else {
            userHasBought = false;
        }
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public String getCommodityID() {
        return commodityID;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean UserHasBought() {
        return userHasBought;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        String hasBought;
        if (userHasBought) {
            hasBought = "";
        } else {
            hasBought = "not";
        }
        return "By user: " + consumer.getUsername() + " about commodity " + commodityID + " which has " + hasBought + "bought the product:" + "\n" + "    " + text;
    }
}
