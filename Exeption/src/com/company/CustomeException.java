package com.company;

public class CustomeException extends  Exception {

    public CustomeException(String message) {
        super("Saját Exception:"+ message);
    }
}
