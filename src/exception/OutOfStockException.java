package exception;

public class OutOfStockException extends InvalidPurchaseException{
    public OutOfStockException(){
        super("Invalid Purchase-"+"Out Of Stock");
    }
    public OutOfStockException(String error){
        super("Invalid Purchase-"+error);
    }
}
