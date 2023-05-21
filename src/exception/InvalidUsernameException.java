package exception;

public class InvalidUsernameException extends InvalidInfoException{
    public InvalidUsernameException(String error){
        super("Invalid Info-"+error);
    }
    public InvalidUsernameException(){
        super("Invalid Info-Invalid Username");
    }
}
