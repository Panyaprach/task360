package com.asg360;

/**
 *
 * @author Panyaprach Tularak
 */
public class ContentNegotiationFailedException extends RuntimeException{
    
    public ContentNegotiationFailedException(String message){
        super(message);
    }
    
    public ContentNegotiationFailedException(String message, Throwable cause){
        super(message, cause);
    }
}
