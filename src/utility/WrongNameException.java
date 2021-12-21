package utility;

public class WrongNameException extends RuntimeException{
    //Custom unchecked exception

    public WrongNameException(String message){
        super(message);
    }

}

