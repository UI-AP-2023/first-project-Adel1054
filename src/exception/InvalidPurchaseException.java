package exception;

public class InvalidPurchaseException extends Exception{
    InvalidPurchaseException(String error){
        super(error);
    }
}
