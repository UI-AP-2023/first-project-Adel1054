package model.user.consumer;

import model.commodity.Commodity;

public class CommentRequest {
    private final Commodity commodity;
    private final Consumer consumer;
    private final String text;
    public CommentRequest(Commodity commodity,Consumer consumer,String text){
        this.commodity= commodity;
        this.consumer=consumer;
        this.text=text;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "from user '"+consumer.getUsername()+"' for commodity '"+commodity.getName()+"' :\n"+text;
    }
}
