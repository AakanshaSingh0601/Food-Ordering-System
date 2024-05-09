package com.employeehierarchy.exception;

public class InvalidEmployeeInfoException extends RuntimeException {
    public InvalidEmployeeInfoException(String message) {
        super(message);
    }
}
