package model.comment;

import user.consumer.Consumer;

public class Comment {
    private final Consumer consumer;
    private final String commodityID;
    private String text;
    enum Status{
        ACCEPTED,REJECTED,TOBECONSIDERED
    }
    private Status status;
    boolean userHasBought;
    Comment(String commodityID,String text,boolean userHasBought,Consumer consumer){
        this.consumer=consumer;
        this.commodityID=commodityID;
        this.text=text;
        status=Status.TOBECONSIDERED;
        this.userHasBought=userHasBought;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCommodityID() {
        return commodityID;
    }

    public Status getStatus() {
        return status;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return consumer.getUsername()+" about commodity "+commodityID+"\n"+"    "+text;
    }
}
