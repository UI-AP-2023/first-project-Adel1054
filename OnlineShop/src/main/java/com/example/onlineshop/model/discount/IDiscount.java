package com.example.onlineshop.model.discount;

public interface IDiscount {
    boolean addDiscountToCommodity(String ID,double percentage,int capacity);
    boolean removeDiscount(String ID);
}
