package com.batrawy.ais.exception;

public class InvalidCoordinatesException extends RuntimeException {
    public InvalidCoordinatesException(String message) {
        super(message);
    }

    public InvalidCoordinatesException(String message, Throwable cause) {
        super(message, cause);
    }
}
