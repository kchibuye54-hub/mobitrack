package com.mobitrack.exception;

public class InvalidTransactionException
        extends Exception {

    public InvalidTransactionException(
            String message) {

        super(message);
    }
}