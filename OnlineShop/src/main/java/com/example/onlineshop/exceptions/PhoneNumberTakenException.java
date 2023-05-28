package com.example.onlineshop.exceptions;

public class PhoneNumberTakenException extends InvalidInfoException{
        public PhoneNumberTakenException(){
            super("Invalid Info-Phone Number Taken");
        }
        public PhoneNumberTakenException(String text){
            super("Invalid Info-"+text);
        }
}
