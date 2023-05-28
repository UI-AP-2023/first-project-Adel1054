package com.example.onlineshop.exceptions;

public class InvalidDiscountException extends Exception{
    public InvalidDiscountException(){
        super("Invalid Purchase-Invalid Discount Code.");
    }
    public InvalidDiscountException(String error){
        super("Invalid Purchase-"+error);
    }
}
