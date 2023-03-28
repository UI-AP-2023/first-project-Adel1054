package model.user.consumer;

import model.commodity.Commodity;
import model.user.consumer.Consumer;

public class Rating {
    private Consumer consumer;
    private int userRating;
    private final Commodity commodity;

    Rating(int userRating, Commodity commodity) {
        this.userRating = userRating;
        this.commodity = commodity;
    }

    public int getUserRating() {
        return userRating;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}