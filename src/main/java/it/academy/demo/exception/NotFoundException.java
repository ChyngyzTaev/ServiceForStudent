package it.academy.demo.exception;

public class NotFoundException extends Throwable{
    private String message;

    public NotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
