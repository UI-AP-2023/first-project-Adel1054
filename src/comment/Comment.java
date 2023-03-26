package comment;

public class Comment {
    //user
    private final String commodityID;
    private String text;
    enum Status{
        ACCEPTED,REJECTED,TOBECONSIDERED
    }
    private Status status;
    boolean userHasBought;
    Comment(String commodityID,String text,boolean userHasBought){
        this.commodityID=commodityID;
        this.text=text;
        status=Status.TOBECONSIDERED;
        this.userHasBought=userHasBought;
    }
}
