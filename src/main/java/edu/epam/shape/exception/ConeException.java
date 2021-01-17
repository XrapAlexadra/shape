package edu.epam.shape.exception;

public class ConeException extends Exception{

    public ConeException() {
        super();
    }

    public ConeException(String s) {
        super(s);
    }

    public ConeException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ConeException(Throwable throwable) {
        super(throwable);
    }
}
