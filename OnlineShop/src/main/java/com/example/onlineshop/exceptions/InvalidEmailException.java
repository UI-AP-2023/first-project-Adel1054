package com.example.onlineshop.exceptions;

public class InvalidEmailException extends Exception{
    public InvalidEmailException(){
        super("Invalid  Info-Invalid Email Address");
    }
    public InvalidEmailException(String error){
        super("Invalid  Info-"+error);
    }
}
