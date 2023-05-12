package com.tenpo.profit.errors.exceptions;

public class PercentageNotFoundException extends RuntimeException {

    public PercentageNotFoundException() {
        super();
    }

    public PercentageNotFoundException(String message) {
        super(message);
    }
}
