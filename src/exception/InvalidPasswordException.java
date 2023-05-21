package exception;

public class InvalidPasswordException extends InvalidInfoException{
    public InvalidPasswordException(String error){
        super("Invalid Info-"+error);
    }
    public InvalidPasswordException(){
        super("Invalid Info-Invalid Password");
    }
}
