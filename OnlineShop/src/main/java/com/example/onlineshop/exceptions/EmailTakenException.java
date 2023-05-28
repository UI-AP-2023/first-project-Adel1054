package com.example.onlineshop.exceptions;

public class EmailTakenException extends InvalidInfoException{
    public EmailTakenException(){
        super("Invalid Info-Email Taken");
    }
    public EmailTakenException(String text){
        super("Invalid Info-"+text);
    }
}
