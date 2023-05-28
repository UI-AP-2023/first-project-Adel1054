package com.example.onlineshop.exceptions;

public class UsernameTakenException extends InvalidInfoException{
    public UsernameTakenException(){
        super("Invalid Info-Username Taken");
    }
    public UsernameTakenException(String text){
        super("Invalid Info-"+text);
    }
}
