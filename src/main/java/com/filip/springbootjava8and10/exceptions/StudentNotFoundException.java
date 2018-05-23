package com.filip.springbootjava8and10.exceptions;

public class StudentNotFoundException extends RuntimeException {

    private Long id;

    public StudentNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return "Student with ID ' " + id + "' not found";
    }

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    protected StudentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
