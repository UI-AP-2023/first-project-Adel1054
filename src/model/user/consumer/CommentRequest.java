package model.user.consumer;

public class CommentRequest {
    private final String commodityID;
    private final String username;
    private final String text;
    public CommentRequest(String commodityID,String username,String text){
        this.commodityID=commodityID;
        this.username=username;
        this.text=text;
    }

    public String getUsername() {
        return username;
    }

    public String getCommodityID() {
        return commodityID;
    }

    public String getText() {
        return text;
    }
}
