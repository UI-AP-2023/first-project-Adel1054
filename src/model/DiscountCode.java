package model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Random;

public class DiscountCode {
    private final double discountPercentage;
    private final LocalDate validDate;
    private int capacity;
    private String discountCode;

    public DiscountCode(double discountPercentage, LocalDate validDate, int capacity) {
        this.discountPercentage = discountPercentage;
        this.validDate = validDate;
        this.capacity = capacity;
        discountCode=makeCode();
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public LocalDate getValidDate() {
        return validDate;
    }

    public void reduceCapacity() {
        capacity--;
    }

    public int getCapacity() {
        return capacity;
    }

    private String makeCode() {
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int x = 1 + (int) Math.abs(rand.nextInt() % 3);
            switch (x) {
                case 1: {
                    int num=Math.abs(rand.nextInt() % 10);
                    sb.append(num);
                }
                break;
                case 2: {
                    char c= (char) (65 + Math.abs(rand.nextInt() % 26));
                    sb.append(c);
                }
                break;
                case 3: {
                    char c= (char) (97 + Math.abs(rand.nextInt() % 26));
                    sb.append(c);
                }
                break;
            }
        }
        return sb.toString();
    }

    public String getDiscountCode() {
        return discountCode;
    }
}
