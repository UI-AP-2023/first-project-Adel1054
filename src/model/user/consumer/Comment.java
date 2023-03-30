package model.user.consumer;

import model.user.consumer.Consumer;

public class Comment {
    private final Consumer consumer;
    private final String commodityID;
    private String text;
    boolean userHasBought;

    public Comment(String commodityID, String text, boolean userHasBought, Consumer consumer) {
        this.consumer = consumer;
        this.commodityID = commodityID;
        this.text = text;
        this.userHasBought = userHasBought;
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

    @Override
    public String toString() {
        return "By user: "+consumer.getUsername() + " about commodity " + commodityID + "\n" + "    " + text;
    }
}
