package model.user.consumer;

public class CreditCard {
    private final String cardNumber;
    private final String CVV2;
    private final String password;
    private double balance;

    public CreditCard(String cardNumber, String CVV2, String password) {
        this.cardNumber = cardNumber;
        this.CVV2 = CVV2;
        this.password = password;
        balance=100000;
    }

    public String getPassword() {
        return password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCVV2() {
        return CVV2;
    }

    public double getBalance() {
        return balance;
    }

    public void changeBalance(double change) {
        balance += change;
    }

    @Override
    public String toString() {
        return "Credit card number: " + cardNumber;
    }
}
