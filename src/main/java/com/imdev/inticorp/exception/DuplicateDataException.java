package com.imdev.inticorp.exception;

public class DuplicateDataException extends RuntimeException {
    
    public DuplicateDataException() {
    }
    
    public DuplicateDataException(String str) {
        super(str);
    }
}
