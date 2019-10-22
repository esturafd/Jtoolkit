package com.esturafd.jtoolkit.exception;

public class ConsoleIOException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public ConsoleIOException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
    
    public ConsoleIOException(String errorMessage) {
        super(errorMessage);
    }
}
