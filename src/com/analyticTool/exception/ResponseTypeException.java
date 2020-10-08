package com.analyticTool.exception;

public class ResponseTypeException extends RuntimeException {

    public ResponseTypeException() {
        super("THE RESPONSE TYPE IS NOT CORRECT! \nThe error type is set ");
    }
}
