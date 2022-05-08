package com.coinmachine.example.exception;

public class InvalidCurrencyException extends RuntimeException{
    public InvalidCurrencyException(String message) {
        super(message);
    }
}
