package com.example.onlineshop.exceptions;

public class InvalidPurchaseException extends Exception{
    InvalidPurchaseException(String error){
        super(error);
    }
}
