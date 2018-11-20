package com.streameast.toolkit.console;

public class MenuException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public MenuException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
    
    public MenuException(String errorMessage) {
        super(errorMessage);
    }
}
