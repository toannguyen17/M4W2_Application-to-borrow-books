package redt.app.exception;

public class NoBooksException extends Exception {
    public NoBooksException(){
        super();
    }
    public NoBooksException(String error){
        super(error);
    }
}
