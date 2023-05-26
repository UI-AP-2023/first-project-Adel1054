package com.example.onlineshop.model.discount;

import com.example.onlineshop.model.commodity.Category;

import java.time.LocalDate;
import java.util.Random;

public class DiscountCode {
    private final double discountPercentage;
    private final LocalDate validDate;
    private final String discountCode;
    private final Category category;
    private final int applicabilityCode;

    public DiscountCode(double discountPercentage, int limitation) {
        this.discountPercentage = discountPercentage;
        validDate = LocalDate.now().plusDays(14);
        discountCode = makeCode();
        applicabilityCode = limitation;
        switch (limitation) {
            case 1:
                category=Category.DIGITAL;
                break;
            case 2:
                category= Category.COMESTIBLE;
                break;
            case 3:
                category=Category.STATIONERY;
                break;
            case 4:
                category=Category.VEHICLE;
                break;
            default:
                category=Category.GENERAL;
                break;
        }
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public LocalDate getValidDate() {
        return validDate;
    }

    private String makeCode() {
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int x = 1 + (int) Math.abs(rand.nextInt() % 3);
            switch (x) {
                case 1: {
                    int num = Math.abs(rand.nextInt() % 10);
                    sb.append(num);
                }
                break;
                case 2: {
                    char c = (char) (65 + Math.abs(rand.nextInt() % 26));
                    sb.append(c);
                }
                break;
                case 3: {
                    char c = (char) (97 + Math.abs(rand.nextInt() % 26));
                    sb.append(c);
                }
                break;
            }
        }
        return sb.toString();
    }

    public Category getCategory() {
        return category;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public int getApplicabilityCode() {
        return applicabilityCode;
    }

    @Override
    public String toString() {
        return "Code: " + discountCode + " Percentage: " + discountPercentage + " Valid until: " + validDate + " Applicable to " + getCategory().toString().toLowerCase();
    }
}
