package org.kreoin.shorturl.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super("message");
    }
}
