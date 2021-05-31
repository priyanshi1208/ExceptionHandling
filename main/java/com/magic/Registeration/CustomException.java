package com.magic.Registeration;

public class CustomException extends RuntimeException {
    ExceptionType type;
    public CustomException(String message,ExceptionType type) {
        super(message);
        this.type=type;
    }
    enum ExceptionType {INVALID_INPUT,INPUT_IS_NULL,INPUT_IS_EMPTY,INPUT_LENGTH_IS_SHORT}
}
