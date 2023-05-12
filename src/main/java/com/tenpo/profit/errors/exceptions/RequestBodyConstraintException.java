package com.tenpo.profit.errors.exceptions;

public class RequestBodyConstraintException extends RuntimeException{

    public RequestBodyConstraintException() {
        super();
    }

    public RequestBodyConstraintException(String message) {
        super(message);
    }
}
