package com.example.onlineshop.exceptions;

public class InvalidInfoException extends Exception{
    InvalidInfoException(String error){
        super(error);
    }
}
