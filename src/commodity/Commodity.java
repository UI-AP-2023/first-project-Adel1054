package commodity;

import category.Category;
import rating.Rating;

import java.util.ArrayList;

public class Commodity {
    protected String ID;
    protected String name;
    protected double price;
    protected int availableCount;
    protected ArrayList<Rating> ratings;
    protected double averageRating;
    protected Category category;
    protected Commodity(String ID,String name,double price,int availableCount,Category category){
        this.availableCount=availableCount;
        this.ID=ID;
        this.name=name;
        this.category=category;
        this.price=price;
        ratings=new ArrayList<>();
        averageRating=0;
    }
}
