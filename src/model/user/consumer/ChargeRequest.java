package model.user.consumer;

public class ChargeRequest {
    private final Consumer consumer;
    private final double amount;
    private final CreditCard creditCard;

    public ChargeRequest(Consumer consumer, double amount, CreditCard creditCard) {
        this.amount = amount;
        this.creditCard = creditCard;
        this.consumer = consumer;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Charge request by user: " + consumer.getUsername() + " With amount of: " + amount;
    }
}
