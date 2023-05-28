package com.example.onlineshop.exceptions;

public class InvalidPhoneNumberException extends InvalidInfoException{
    public InvalidPhoneNumberException(){
        super("Invalid  Info-Invalid Phone Number.");
    }
    public InvalidPhoneNumberException(String error){
        super("Invalid  Info-"+error);
    }
}
